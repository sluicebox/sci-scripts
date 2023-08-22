;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
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
	rm69 0
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
		(Print 69 7) ; "The sneaky little dwarf caught you by surprise. Did he steal anything from you?"
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_1) ; UNUSED
	(if (IsFlag 1)
		(Print 69 8) ; "As you fall, the magic ring slips from your finger."
		(gGame changeScore: -3)
	)
)

(procedure (localproc_2)
	(if (IsFlag 1)
		(gEgo view: 42)
	else
		(gEgo view: 56)
	)
)

(instance rm69 of Rm
	(properties
		picture 69
		horizon 20
		south 68
		west 59
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
					(west 3)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(south
				(gEgo posn: 189 187 setLoop: 0 cel: 0)
			)
			(west
				(gEgo loop: 0 posn: 1 39)
			)
			(else
				(gEgo posn: 150 130)
			)
		)
		(SetFlag 0)
		(gEgo init:)
		(proc0_1)
		(if (not (IsFlag 28))
			(if (not (IsFlag 31))
				(cond
					((< (Random 1 100) 51)
						(ClearFlag 29)
						(ClearFlag 30)
					)
					((< (Random 1 100) 51)
						(SetFlag 30)
						(ClearFlag 29)
					)
					(else
						(SetFlag 29)
						(ClearFlag 30)
					)
				)
				(SetFlag 31)
			)
			(dwarf view: 136 setCycle: Walk init: hide:)
		)
		(cave init:)
	)

	(method (doit &tmp temp0)
		(if (and (< (gEgo y:) 96) (>= (gEgo x:) 219) (not (IsFlag 1)))
			(= local2 1)
		)
		(if (and (>= (gEgo y:) 96) (>= (gEgo x:) 136) (not (IsFlag 1)))
			(= local3 1)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(IsFlag 30)
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
					(IsFlag 30)
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
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(if (== (gEgo edgeHit:) EDGE_LEFT)
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
				(Print 69 0) ; "The walkway is made from large wooden planks, attached firmly to the cave's walls and floor, and suspended from the ceiling."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,cave]')
						(Print 69 1) ; "The suspended walkway seems to wind forever down into the very bowels of the mountain."
					)
					((Said '/catwalk,path')
						(Print 69 0) ; "The walkway is made from large wooden planks, attached firmly to the cave's walls and floor, and suspended from the ceiling."
					)
					((Said '/dwarf,man')
						(Print 69 2) ; "There is no dwarf here."
					)
				)
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
				(localproc_2)
				(gEgo
					illegalBits: 0
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo posn: 153 57)
				(= seconds 4)
			)
			(2
				(proc0_1)
				(gEgo loop: 0 cel: 0 setPri: 1 setMotion: MoveTo 174 56 self)
			)
			(3
				(gEgo setPri: -1)
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
				(gEgo setPri: 1 setMotion: MoveTo 155 57 self)
			)
			(1
				(localproc_2)
				(gEgo
					illegalBits: 0
					setLoop: 0
					cel: 0
					setCycle: 0
					setMotion: MoveTo 90 109 self
				)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(proc0_1)
				(gEgo loop: 2 cel: 0 setMotion: MoveTo 90 114 self)
			)
			(4
				(gEgo setPri: -1)
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
				(AmigaPauseBackSound 1)
				((ScriptID 0 21) number: 93 loop: 1 init: play:) ; gameSound
				(Print 69 3) ; "Suddenly, a small dwarf runs out of the shadows and approaches you."
				(dwarf show:)
				(if (= local1 (< (gEgo y:) 95))
					(dwarf posn: 156 61 setMotion: MoveTo 201 52 self)
				else
					(dwarf posn: 94 106 setMotion: MoveTo 91 113 self)
				)
			)
			(1
				(if local1
					(self cue:)
				else
					(dwarf setMotion: MoveTo 107 125 self)
				)
			)
			(2
				(cond
					(global124
						(Print 69 4) ; "It's a good thing you are protected by a spell. That little dwarf likes to steal treasures."
					)
					((IsFlag 1)
						(Print 69 5) ; "Being invisible has protected you, and your treasures, from the dwarf."
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
						(Print 69 6) ; "The sneaky little dwarf came by to see what you had...but nothing caught his fancy."
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
				(AmigaPauseBackSound 0)
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

(instance cave of NewFeature
	(properties
		x 94
		y 89
		noun 'cave'
		nsTop 68
		nsLeft 71
		nsBottom 111
		nsRight 117
		description {cave}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {You can't see much of anything in the dark cave.}
	)
)

