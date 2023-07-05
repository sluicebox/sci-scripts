;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm68 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2)
	(if (gEgo has: param1)
		(gEgo put: param1)
		(gGame changeScore: (- 0 param2))
		(Print 68 7) ; "The sneaky little dwarf caught you by surprise. Did he steal anything from you?"
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_1)
	(if (IsFlag 1)
		(gEgo view: 42)
	else
		(gEgo view: 56)
	)
)

(instance rm68 of Rm
	(properties
		picture 68
		horizon 59
		north 69
		south 67
	)

	(method (init)
		(LoadMany rsVIEW 4 7 56 66 136)
		(if (gEgo has: 5) ; Magic_Ring
			(LoadMany rsVIEW 38 39)
		)
		(Load rsSCRIPT 613)
		(Load rsSOUND 17)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 43 45 setLoop: 2 cel: 0)
			)
			(south
				(gEgo posn: 80 187)
			)
			(else
				(gEgo posn: 196 115)
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (== gPrevRoomNum north)
			(self setScript: fadeInRoom)
		)
		(if (not (IsFlag 28))
			(if (not (IsFlag 31))
				(cond
					((< (Random 1 100) 51)
						(ClearFlag 29)
						(ClearFlag 30)
					)
					((< (Random 1 100) 51)
						(SetFlag 29)
						(ClearFlag 30)
					)
					(else
						(SetFlag 30)
						(ClearFlag 29)
					)
				)
				(SetFlag 31)
			)
			(dwarf view: 136 setCycle: Walk init: hide:)
		)
		(cave1 init:)
		(cave2 init:)
	)

	(method (doit &tmp temp0)
		(if (and (< (gEgo y:) 96) (< (gEgo x:) 172) (not (IsFlag 1)))
			(= local2 1)
		)
		(if (and (>= (gEgo y:) 96) (< (gEgo x:) 247) (not (IsFlag 1)))
			(= local3 1)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(IsFlag 29)
					(not (IsFlag 28))
					(== (gEgo onControl: 1) 1024)
					(not (IsFlag 1))
					(>= (gEgo y:) 95)
					local3
				)
				(self setScript: takeWhatYouCan)
			)
			(
				(and
					(IsFlag 29)
					(not (IsFlag 28))
					(== (gEgo onControl: 1) 1024)
					(not (IsFlag 1))
					(< (gEgo y:) 96)
					local2
				)
				(self setScript: takeWhatYouCan)
			)
			((== (gEgo onControl: 1) 8)
				(self setScript: (ScriptID 613 0)) ; fallRight
			)
			((== (gEgo onControl: 1) 16)
				(self setScript: (ScriptID 613 1)) ; fallLeft
			)
			((== (gEgo onControl: 1) 256)
				(self setScript: (ScriptID 613 2)) ; fallSEast
			)
			((== (gEgo onControl: 1) 2)
				(self setScript: (ScriptID 613 3)) ; fallSWest
			)
			((== (gEgo onControl: 1) 4)
				(self setScript: (ScriptID 613 4)) ; fallNorth
			)
			((== (gEgo onControl: 1) 16384)
				(self setScript: (ScriptID 613 6)) ; longFallFront
			)
			((== (gEgo onControl: 1) 64)
				(self setScript: fadeOut)
			)
			((== (gEgo onControl: 1) 32)
				(self setScript: fadeIn)
			)
			((== (gEgo onControl: 1) 128)
				(self setScript: fadeOutRoom)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(if (== (gEgo edgeHit:) 3)
					(ClearFlag 31)
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(& (OnControl CONTROL (event x:) (event y:)) $0c00)
					(User canInput:)
				)
				(event claimed: 1)
				(Print 68 0) ; "The walkway is made from large wooden planks, attached firmly to the cave's walls and floor."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,cave]')
						(Print 68 1) ; "The suspended walkway seems to wind forever down into the very bowels of the mountain."
					)
					((Said '/catwalk,path')
						(Print 68 0) ; "The walkway is made from large wooden planks, attached firmly to the cave's walls and floor."
					)
					((Said '/dwarf,man')
						(Print 68 2) ; "There is no dwarf here."
					)
				)
			)
		)
	)
)

(instance fadeOutRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_1)
				(gEgo
					setLoop: 1
					illegalBits: 0
					cel: 0
					setMotion: MoveTo (gEgo x:) 60
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo posn: 49 60)
				(= seconds 2)
			)
			(2
				(HandsOn)
				(self dispose:)
				(gCurRoom newRoom: 69)
			)
		)
	)
)

(instance fadeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 0)
				(= local3 0)
				(localproc_1)
				(gEgo
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) 77 self
				)
			)
			(1
				(proc0_1)
				(gEgo loop: 1 cel: 0 setMotion: MoveTo 237 77 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fadeInRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_1)
				(gEgo
					setLoop: 0
					cel: 0
					setCycle: 0
					setMotion: MoveTo 45 57 self
				)
			)
			(1
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(2
				(proc0_1)
				(gEgo loop: 2 cel: 0 setMotion: MoveTo 45 69 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fadeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 0)
				(= local3 0)
				(gEgo setMotion: MoveTo 300 (gEgo y:) self)
			)
			(1
				(localproc_1)
				(gEgo
					setLoop: 0
					cel: 0
					setCycle: 0
					setMotion: MoveTo 300 95 self
				)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(proc0_1)
				(gEgo loop: 2 cel: 0 setMotion: MoveTo 300 114 self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance takeWhatYouCan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 93 loop: 1 init: play:) ; gameSound
				(Print 68 3) ; "Suddenly, a small dwarf runs out of the shadows and approaches you."
				(dwarf show:)
				(if (= local1 (< (gEgo y:) 96))
					(dwarf posn: 243 74 setMotion: MoveTo 189 74 self)
				else
					(dwarf posn: 308 108 setMotion: MoveTo 288 119 self)
				)
			)
			(1
				(if local1
					(self cue:)
				else
					(dwarf setMotion: MoveTo 264 121 self)
				)
			)
			(2
				(cond
					(global124
						(Print 68 4) ; "It's a good thing you are protected by a spell. That little dwarf likes to steal treasures."
					)
					((IsFlag 1)
						(Print 68 5) ; "Being invisible has protected you, and your treasures, from the dwarf."
					)
					((localproc_0 16 8))
					((localproc_0 14 8))
					((localproc_0 1 8))
					((and (IsFlag 62) (localproc_0 11 6)))
					((localproc_0 11 3))
					((and (IsFlag 67) (localproc_0 18 6)))
					((localproc_0 15 6))
					((localproc_0 12 6))
					(else
						(Print 68 6) ; "The sneaky little dwarf came by to see what you had...but nothing caught his fancy."
					)
				)
				(= cycles 10)
			)
			(3
				(dwarf loop: 3 cel: 0)
				(= cycles 2)
			)
			(4
				(dwarf setCycle: End self)
			)
			(5
				((ScriptID 0 21) fade:) ; gameSound
				(SetFlag 28)
				(dwarf dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dwarf of Actor
	(properties)
)

(instance cave1 of NewFeature
	(properties
		x 49
		y 38
		noun 'cave'
		nsTop 10
		nsLeft 26
		nsBottom 66
		nsRight 73
		description {cave}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You can't see much of anything in the dark cave.}
	)
)

(instance cave2 of NewFeature
	(properties
		x 293
		y 79
		noun 'cave'
		nsTop 48
		nsLeft 269
		nsBottom 111
		nsRight 318
		description {cave}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You can't see much of anything in the dark cave.}
	)
)

