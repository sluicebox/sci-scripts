;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm67 0
)

(instance rm67 of Rm
	(properties
		picture 67
		horizon 35
		east 68
		west 66
	)

	(method (init)
		(LoadMany rsVIEW 4 7 56 66 136)
		(Load rsSCRIPT 613)
		(Load rsSOUND 17)
		(if (gEgo has: 5) ; Magic_Ring
			(LoadMany rsVIEW 38 39)
		)
		(self
			style:
				(switch gPrevRoomNum
					(west 3)
					(else 2)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 17 186 loop: 0)
			)
			(else
				(gEgo posn: 299 56)
			)
		)
		(SetFlag 0)
		(gEgo init:)
		(proc0_1)
		(walkway1 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo priority:) 1)
				(gEgo setPri: 2)
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
			((== (gEgo onControl: 1) 1024)
				(self setScript: (ScriptID 613 5)) ; longFallBack
			)
			((== (gEgo onControl: 1) 16384)
				(self setScript: (ScriptID 613 6)) ; longFallFront
			)
			((gEgo inRect: 0 50 15 61)
				(self setScript: goingLow)
			)
			((gEgo inRect: 0 71 15 83)
				(self setScript: goingHigh)
			)
			((== (gEgo onControl: 1) 8192)
				(self newRoom: 68)
			)
			((== (gEgo onControl: 1) 4096)
				(ClearFlag 0)
				(ClearFlag 31)
				(self newRoom: 66)
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
					(& (OnControl CONTROL (event x:) (event y:)) $0800)
					(User canInput:)
				)
				(event claimed: 1)
				(Print 67 0) ; "The walkway is made from large wooden planks, attached firmly to the cave's walls and floor."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,cave]')
						(Print 67 1) ; "The suspended walkway seems to wind forever down into the very bowels of the mountain."
					)
					((Said '/catwalk,path')
						(Print 67 0) ; "The walkway is made from large wooden planks, attached firmly to the cave's walls and floor."
					)
				)
			)
		)
	)
)

(instance goingLow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_1)
				(gEgo illegalBits: 0 loop: 0 cel: 0 posn: 17 78)
				(= seconds 2)
			)
			(1
				(gEgo setStep: 2 2 setMotion: MoveTo 30 78 self)
			)
			(2
				(gEgo illegalBits: $8000)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goingHigh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_1)
				(gEgo illegalBits: 0 loop: 1 cel: 0 posn: 17 56)
				(= seconds 2)
			)
			(1
				(gEgo setStep: 2 2 setMotion: MoveTo 31 56 self)
			)
			(2
				(gEgo illegalBits: $8000)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkway1 of NewFeature
	(properties
		x 164
		y 56
		noun 'catwalk<overhead'
		nsTop 50
		nsLeft 27
		nsBottom 63
		nsRight 301
		description {overhead walkway}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There is a wooden walkway suspended from the cave's ceiling.}
	)
)

