;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use Interface)
(use IconBar)
(use PolyPath)
(use Feature)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sewer 0
	theDeathScript 1
	theSlime 2
	theDrip 3
	theSlimeScript 4
)

(local
	local0
	local1
	local2
	[local3 52]
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	local66
	local67
)

(procedure (localproc_0)
	(cond
		((== (theSlime loop:) 3)
			(= local55 (- (theSlime x:) 9))
			(= local56 (- (theSlime y:) 27))
			(= local57 (- (theSlime x:) 9))
			(= local58 (+ (theSlime y:) 26))
			(sewer distance: (localproc_1))
			(= local55 (- (theSlime x:) 9))
			(= local56 (- (theSlime y:) 27))
			(= local57 (+ (theSlime x:) 9))
			(= local58 (- (theSlime y:) 27))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 9))
			(= local56 (- (theSlime y:) 27))
			(= local57 (+ (theSlime x:) 9))
			(= local58 (+ (theSlime y:) 26))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x:) 9))
			(= local56 (+ (theSlime y:) 26))
			(= local57 (+ (theSlime x:) 9))
			(= local58 (+ (theSlime y:) 26))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop:) 2)
			(= local55 (- (theSlime x:) 35))
			(= local56 (- (theSlime y:) 5))
			(= local57 (- (theSlime x:) 35))
			(= local58 (+ (theSlime y:) 6))
			(sewer distance: (localproc_1))
			(= local55 (- (theSlime x:) 35))
			(= local56 (- (theSlime y:) 5))
			(= local57 (+ (theSlime x:) 35))
			(= local58 (- (theSlime y:) 5))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 35))
			(= local56 (- (theSlime y:) 5))
			(= local57 (+ (theSlime x:) 35))
			(= local58 (+ (theSlime y:) 6))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 35))
			(= local56 (+ (theSlime y:) 6))
			(= local57 (- (theSlime x:) 35))
			(= local58 (+ (theSlime y:) 6))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop:) 0)
			(= local55 (- (theSlime x:) 28))
			(= local56 (+ (theSlime y:) 15))
			(= local57 (+ (theSlime x:) 9))
			(= local58 (- (theSlime y:) 17))
			(sewer distance: (localproc_1))
			(= local55 (- (theSlime x:) 28))
			(= local56 (+ (theSlime y:) 15))
			(= local57 (- (theSlime x:) 10))
			(= local58 (+ (theSlime y:) 21))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x:) 10))
			(= local56 (+ (theSlime y:) 21))
			(= local57 (+ (theSlime x:) 23))
			(= local58 (- (theSlime y:) 9))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 9))
			(= local56 (- (theSlime y:) 17))
			(= local57 (+ (theSlime x:) 23))
			(= local58 (- (theSlime y:) 9))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop:) 1)
			(= local55 (- (theSlime x:) 24))
			(= local56 (- (theSlime y:) 9))
			(= local57 (+ (theSlime x:) 13))
			(= local58 (+ (theSlime y:) 23))
			(sewer distance: (localproc_1))
			(= local55 (- (theSlime x:) 24))
			(= local56 (- (theSlime y:) 9))
			(= local57 (- (theSlime x:) 8))
			(= local58 (- (theSlime y:) 17))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x:) 8))
			(= local56 (- (theSlime y:) 17))
			(= local57 (+ (theSlime x:) 28))
			(= local58 (+ (theSlime y:) 16))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 13))
			(= local56 (+ (theSlime y:) 23))
			(= local57 (+ (theSlime x:) 28))
			(= local58 (+ (theSlime y:) 16))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(if
		(and
			(<=
				0
				(localproc_2
					(- local57 local55)
					(- local58 local56)
					(- local59 local55)
					(- local60 local56)
				)
			)
			(<=
				0
				(localproc_2
					(- local55 local57)
					(- local56 local58)
					(- local59 local57)
					(- local60 local58)
				)
			)
		)
		(return
			(if (= temp0 (GetDistance local55 local56 local57 local58))
				(/
					(Abs
						(localproc_2
							(- local58 local56)
							(- local55 local57)
							(- local59 local55)
							(- local60 local56)
						)
					)
					temp0
				)
			else
				0
			)
		)
	else
		(return
			(Min
				(GetDistance local59 local60 local55 local56)
				(GetDistance local59 local60 local57 local58)
			)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(if (< (sewer distance:) 200)
		(return (+ (* param1 param3) (* param2 param4)))
	else
		(return
			(+
				(* (+ (/ param1 2) 1) (+ (/ param3 2) 1))
				(* (+ (/ param2 2) 1) (+ (/ param4 2) 1))
			)
		)
	)
)

(class sewer of Rgn
	(properties
		regionVer 11891
		roomVer 0
		location 0
		busy 0
		cantDie 0
		status 0
		distance 0
		prevDistance 0
		oldDistance 0
		angle 0
		scoopLoop 0
		rmTimer 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 75 80 85 90 95 100 105 110 115))
		(= initialized 0)
		(theSlime setScript: 0 setCycle: 0 setMotion: 0 dispose:)
		(theDrip setScript: 0 setCycle: 0 setMotion: 0 dispose:)
		(super newRoom: newRoomNumber &rest)
		(= local67 0)
		(self
			oldDistance: (sewer prevDistance:)
			prevDistance: (sewer distance:)
		)
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 75)
		(Load rsVIEW 76)
		(Load rsVIEW 4)
		(Load rsSOUND 806)
		(Load rsSOUND 805)
		(sewer cantDie: 0)
		(gLongSong number: 805 loop: -1 playBed:)
		(gLongSong2 number: 806 loop: -1)
		(if (OneOf gCurRoomNum 75 80 85 105 115)
			(gCurRoom setFeatures: thePipes theConduit theVent)
		else
			(gCurRoom setFeatures: thePipes theConduit)
		)
		(if (not (sewer location:))
			(theSlime posn: 1000 1000)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (!= local64 (GetTime 1)) ; SysTime12
			(= local64 (GetTime 1)) ; SysTime12
			(= local65 1)
		)
		(if local65
			(= local65 0)
			(++ local67)
			(self rmTimer: local67)
			(if (== (self status:) 4)
				(++ local66)
				(if (and (not (sewer cantDie:)) (> local66 5))
					(HandsOff)
					(Print 702 0) ; "*** You ran out of time..."
					(gCurRoom setScript: theDeathScript)
				)
			)
		)
		(= local59 (gEgo x:))
		(= local60 (gEgo y:))
		(localproc_0)
		(sewer
			angle:
				(GetAngle (gEgo x:) (gEgo y:) (theSlime x:) (theSlime y:))
		)
		(if
			(and
				(< (sewer distance:) 5)
				(== (sewer status:) 4)
				(not local0)
				(not (sewer cantDie:))
			)
			(gCurRoom setScript: theDeathScript)
			(sewer status: 6)
		)
		(if (and (> (sewer distance:) 17) (== (sewer status:) 4))
			(sewer status: 3)
			(theSlime setScript: theSlimeScript)
			(= local66 0)
		)
		(if
			(and
				(< (sewer status:) 7)
				(> (sewer distance:) 0)
				(< (sewer distance:) 9)
				(== (sewer status:) 3)
				(== (sewer location:) gCurRoomNum)
				(not (sewer cantDie:))
			)
			(sewer status: 4)
			(theSlime setScript: 0 setCycle: Fwd setMotion: 0)
		)
	)

	(method (dispose)
		(DisposeScript 941)
		(DisposeScript 969)
		(DisposeScript 972)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance theDrip of Actor
	(properties
		description {slime}
		lookStr {A green gel-type mass flows out the vent and down the conduit section.}
		yStep 1
		view 75
		signal 26624
		illegalBits 0
		xStep 1
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 969)
	)
)

(instance theDeathScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (self state:) 4) (== (gLongSong prevSignal:) -1))
			(gLongSong prevSignal: 0)
			(self cue:)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(sewer status: 7)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					cycleSpeed: 0
					setMotion: 0
					setLoop: -1
					setHeading: 180 self
				)
				(gLongSong2 fade:)
				(gLongSong number: 818 vol: 127 loop: 1 playBed:)
			)
			(1
				(theSlime moveSpeed: 0 cycleSpeed: 0 setStep: 3 3)
				(switch (theSlime loop:)
					(2
						(theSlime
							setMotion:
								MoveTo
								(gEgo x:)
								(- (gEgo y:) 3)
								self
						)
					)
					(else
						(theSlime
							setMotion: MoveTo (gEgo x:) (gEgo y:) self
						)
					)
				)
				(gEgo view: 76 setLoop: 0 setCel: 0)
			)
			(2
				(theSlime cycleSpeed: 1)
				(gEgo cycleSpeed: 2 setCycle: End self)
			)
			(3
				(gEgo setLoop: 1 setCycle: End self)
			)
			(4
				(theSlime setCycle: Fwd)
				(gEgo hide:)
			)
			(5
				(EgoDead 702 1) ; "As the green slime dissolves the flesh from your bones, you think, "Hey! This stuff consumes 47 times its weight in acid!""
			)
		)
	)
)

(instance theSlime of Actor
	(properties
		description {slime}
		lookStr {A blob of slime has gained an attraction for you. The green, viscuous, congealed, wad of bile helper seems to leave the pipe cleaner than when it first flowed over.__Is it bent on your destruction? Or is it just a friendly scum-puddle of some exciting new tasty treat? Dare you find out?}
		view 75
		signal 26624
		illegalBits 0
	)

	(method (dispose)
		(super dispose:)
		(= local67 0)
	)

	(method (init)
		(super init:)
		(self setStep: 2 2)
		(if (== (self loop:) 0)
			(self moveSpeed: 1)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(switch (sewer status:)
					(4
						(HandsOff)
						(Print 702 2) ; "You bend down and scoop up some slime with both hands cupped."
						(gEgo
							setMotion: PolyPath (theSlime x:) (theSlime y:)
						)
					)
					(3
						(Print 702 3) ; "You're not close enough."
					)
					(else
						(Print 702 4) ; "You wave at the slime."
					)
				)
			)
			(6 ; Inventory
				(cond
					((!= invItem 5) ; jar
						(Print 702 5) ; "That has no effect on the green slime!"
					)
					((IsFlag 22)
						(Print 702 6) ; "You have all of that toxic spew that you wish to carry."
					)
					(else
						(Load rsVIEW 81)
						(Load rsSOUND 820)
						(switch (sewer status:)
							(4
								(gCurRoom setScript: scoopScript)
							)
							(3
								(switch gCurRoomNum
									(90
										(if
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop:) 0)
											)
											(cond
												((< (theSlime y:) 70)
													(Print 702 7) ; "*** Be patient... it's almost in the right position!"
												)
												((> (theSlime y:) 100)
													(Print 702 8) ; "*** Too late! It's too far away from where you stand!"
												)
												(else
													(gCurRoom
														setScript: scoopScript
													)
												)
											)
										else
											(Print 702 9) ; "*** The slime's not quite in the right position for that!"
										)
									)
									(95
										(if
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop:) 3)
											)
											(cond
												((< (theSlime y:) 60)
													(Print 702 7) ; "*** Be patient... it's almost in the right position!"
												)
												((> (theSlime y:) 110)
													(Print 702 8) ; "*** Too late! It's too far away from where you stand!"
												)
												(else
													(gCurRoom
														setScript: scoopScript
													)
												)
											)
										else
											(Print 702 9) ; "*** The slime's not quite in the right position for that!"
										)
									)
									(100
										(if
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop:) 1)
											)
											(cond
												((< (theSlime y:) 75)
													(Print 702 7) ; "*** Be patient... it's almost in the right position!"
												)
												((> (theSlime y:) 95)
													(Print 702 8) ; "*** Too late! It's too far away from where you stand!"
												)
												(else
													(gCurRoom
														setScript: scoopScript
													)
												)
											)
										else
											(Print 702 9) ; "*** The slime's not quite in the right position for that!"
										)
									)
									(115
										(if
											(and
												(& (gEgo onControl: 1) $0002)
												(> (theSlime y:) 105)
												(== (theSlime loop:) 1)
											)
											(gCurRoom setScript: scoopScript)
										else
											(Print 702 10) ; "*** Unfortunately, the slime's already too far away for that!"
										)
									)
									(105
										(if
											(and
												(& (gEgo onControl: 1) $0002)
												(> (theSlime y:) 105)
												(== (theSlime loop:) 0)
											)
											(gCurRoom setScript: scoopScript)
										else
											(Print 702 10) ; "*** Unfortunately, the slime's already too far away for that!"
										)
									)
									(else
										(switch (Random 1 3)
											(1
												(Print 702 11) ; "You are not in a good position for that."
											)
											(2
												(Print 702 12) ; "You can't do that from where you stand."
											)
											(3
												(Print 702 13) ; "Get closer."
											)
										)
									)
								)
							)
							(else
								(Print 702 14) ; "That's not possible now."
							)
						)
					)
				)
			)
			(3 ; Taste
				(Print 702 15) ; "*** You wouldn't want to!"
			)
			(2 ; Smell
				(Print 702 16) ; "*** Smells like your common variety of green slime."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scoopScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 702 17) ; "*** Okay."
				(theSlime moveSpeed: 3)
				(SetFlag 22)
				(= local0 1)
				(sewer status: 5)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(gEgo normal: 0 cycleSpeed: 1 illegalBits: 0 ignoreActors: 1)
				(cond
					((or (> (sewer angle:) 270) (< (sewer angle:) 20))
						(sewer scoopLoop: 3)
						(gEgo setLoop: -1 setHeading: 315 self)
					)
					((and (> (sewer angle:) 19) (< (sewer angle:) 100))
						(sewer scoopLoop: 4)
						(gEgo setLoop: -1 setHeading: 45 self)
					)
					((and (> (sewer angle:) 99) (< (sewer angle:) 190))
						(sewer scoopLoop: 1)
						(gEgo setLoop: -1 setHeading: 135 self)
					)
					((and (> (sewer angle:) 189) (< (sewer angle:) 271))
						(sewer scoopLoop: 0)
						(gEgo setLoop: -1 setHeading: 225 self)
					)
				)
			)
			(1
				(= register (gEgo loop:))
				(gEgo
					view: 81
					cel: 0
					cycleSpeed: 2
					setLoop: (sewer scoopLoop:)
					setCycle: CT 2 1 self
				)
			)
			(2
				(gLongSong2 number: 820 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setMotion: MoveTo local1 local2 self)
			)
			(4
				(= local66 0)
				(HandsOn)
				(Print 702 18) ; "I'd be staying clear of that slime puddle at all possible opportunities."
				((gInventory at: 5) cel: 2 cursor: 16) ; jar
				((IconBar at: 6) cursor: 16)
				(NormalEgo register 0)
				(theSlime ignoreActors: 0 moveSpeed: 1)
				(= seconds 3)
			)
			(5
				(= local0 0)
				(theSlime ignoreActors: 1)
				(sewer status: 4)
				(self dispose:)
			)
		)
	)
)

(instance thePipes of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {pipes}
		onMeCheck 16
		lookStr {The pipes running along the sides of this conduit are coated in inert slime.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 702 19) ; "You really don't want to touch the slime-laden pipes."
			)
			(5) ; Talk
			(3 ; Taste
				(Print 702 20) ; "*** They taste like pipes."
			)
			(2 ; Smell
				(Print 702 21) ; "*** They smell like slimy pipes."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theConduit of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {sewer}
		onMeCheck 32
		lookStr {This is a section of the Xenon sewer system. Happily, there seems to be very little of the kind of compost usually associated with sewers. Conduits line the sides of the dim, musty tunnel, which stretches off into the darkness to the south and east.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(3 ; Taste
				(Print 702 22) ; "*** The floor tastes like the floor in you-know-who's bathroom!"
			)
			(2 ; Smell
				(Print 702 23) ; "*** It smells like you-know-who was here."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theVent of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {vent}
		onMeCheck 64
		lookStr {There's a small vent set into the side of the sewer tunnel. Unfortunately, it looks way too narrow for a space janitor, even a wiry, skinny one, to squeeze inside.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(3 ; Taste
				(Print 702 24) ; "*** Your tongue does not reach."
			)
			(2 ; Smell
				(Print 702 25) ; "*** You can't quite reach the vent."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSlimeScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== register 1) (< (sewer distance:) 20))
			(= register 0)
			(self init:)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch gCurRoomNum
					(75
						(= local62 8)
						(= local63 207)
					)
					(80
						(= local62 158)
						(= local63 227)
					)
					(85
						(= local62 311)
						(= local63 209)
					)
					(90
						(switch (theSlime loop:)
							(2
								(= local62 358)
								(= local63 89)
							)
							(else
								(= local62 30)
								(= local63 195)
							)
						)
					)
					(95
						(switch (theSlime loop:)
							(2
								(if (== gPrevRoomNum 100)
									(if (< (gEgo x:) (theSlime x:))
										(= local62 218)
										(= local63 91)
									else
										(= local62 359)
										(= local63 91)
									)
								else
									(= local62 98)
									(= local63 89)
								)
							)
							(else
								(= local62 158)
								(= local63 220)
							)
						)
					)
					(100
						(switch (theSlime loop:)
							(2
								(= local62 -39)
								(= local63 91)
							)
							(else
								(= local62 312)
								(= local63 211)
							)
						)
					)
					(105
						(switch (theSlime loop:)
							(0
								(if (< (gEgo y:) (theSlime y:))
									(= local62 225)
									(= local63 -7)
								else
									(= local62 94)
									(= local63 111)
								)
							)
							(2
								(switch gPrevRoomNum
									(110
										(if (> (gEgo x:) (theSlime x:))
											(= local62 337)
											(= local63 125)
										else
											(= local62 118)
											(= local63 125)
										)
									)
									(else
										(= local62 337)
										(= local63 125)
									)
								)
							)
						)
					)
					(110
						(switch (theSlime loop:)
							(2
								(if (< (gEgo x:) (theSlime x:))
									(= local62 -30)
									(= local63 125)
								else
									(= local62 337)
									(= local63 125)
								)
							)
							(3
								(if (< (gEgo y:) (theSlime y:))
									(= local62 158)
									(= local63 109)
								else
									(= local62 158)
									(= local63 -18)
								)
							)
						)
					)
					(115
						(switch (theSlime loop:)
							(1
								(= local62 233)
								(= local63 113)
							)
							(2
								(if (< (gEgo x:) (theSlime x:))
									(= local62 -36)
									(= local63 127)
								else
									(= local62 183)
									(= local63 127)
								)
							)
						)
					)
				)
				(theSlime
					setPri: 1
					setCycle: Fwd
					setMotion: MoveTo local62 local63 self
				)
			)
			(1
				(theSlime setCycle: Rev)
				(switch gCurRoomNum
					(80
						(sewer busy: 0)
						(self dispose:)
					)
					(90
						(if (< (theSlime y:) 0)
							(sewer location: 75)
						else
							(sewer location: 105)
						)
						(theSlime posn: 1000 1000 dispose:)
						(gLongSong fade: 127 10 10 0)
						(gLongSong2 fade:)
						(self dispose:)
					)
					(95
						(if (== (theSlime loop:) 2)
							(if (== gPrevRoomNum 100)
								(theSlime setMotion: MoveTo 352 91 self)
							else
								(= register 1)
								(theSlime setMotion: MoveTo -32 89 self)
							)
						else
							(theSlime posn: 1000 1000 dispose:)
							(sewer busy: 0 location: 110)
							(gLongSong fade: 127 10 10 0)
							(gLongSong2 fade:)
							(self dispose:)
						)
					)
					(100
						(theSlime posn: 1000 1000 dispose:)
						(gLongSong fade: 127 10 10 0)
						(gLongSong2 fade:)
						(if (< (gEgo y:) 100)
							(sewer location: 0 status: 0)
						)
						(self dispose:)
					)
					(105
						(switch (theSlime loop:)
							(0
								(theSlime setMotion: MoveTo 139 70 self)
							)
							(2
								(switch gPrevRoomNum
									(110
										(if (== local62 118)
											(self init:)
										else
											(theSlime posn: 1000 1000 dispose:)
											(sewer location: 110)
											(gLongSong fade: 127 10 10 0)
											(gLongSong2 fade:)
										)
									)
									(else
										(= register 1)
										(theSlime
											setMotion: MoveTo 118 125 self
										)
									)
								)
							)
						)
					)
					(110
						(if (== (theSlime loop:) 3)
							(= register 1)
							(theSlime setMotion: MoveTo 158 -29 self)
						else
							(theSlime posn: 1000 1000 dispose:)
							(sewer location: 115)
							(gLongSong fade: 127 10 10 0)
							(gLongSong2 fade:)
							(self dispose:)
						)
					)
					(115
						(switch (theSlime loop:)
							(2
								(theSlime setMotion: MoveTo -27 125 self)
							)
							(else
								(theSlime setMotion: MoveTo 191 82 self)
							)
						)
					)
					(else
						(theSlime posn: 1000 1000 dispose:)
						(gLongSong2 fade:)
						(gLongSong fade: 127 10 10 0)
						(gLongSong2 fade:)
						(self dispose:)
					)
				)
			)
			(2
				(switch gCurRoomNum
					(115
						(switch (theSlime loop:)
							(2
								(theSlime posn: 1000 1000 dispose:)
								(gLongSong2 fade:)
								(gLongSong fade: 127 10 10 0)
								(gLongSong2 fade:)
								(sewer location: 110)
								(self dispose:)
							)
							(else
								(= register 1)
								(theSlime setMotion: MoveTo 87 -7 self)
							)
						)
					)
					(105
						(= register 1)
						(theSlime setMotion: MoveTo 225 -7 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(= register 0)
				(switch gCurRoomNum
					(105
						(switch (theSlime loop:)
							(0
								(sewer location: 90)
							)
							(2
								(sewer location: 110)
							)
						)
					)
					(95
						(sewer location: gPrevRoomNum)
					)
					(115
						(sewer location: 100)
						(cond
							((< (gEgo y:) 70)
								(sewer prevDistance: 1)
							)
							((< (gEgo y:) 105)
								(sewer prevDistance: 2)
							)
							((> (gEgo x:) 190)
								(sewer prevDistance: 3)
							)
							(else
								(sewer prevDistance: 4)
							)
						)
					)
				)
				(theSlime setMotion: 0 setCycle: 0 posn: 1000 1000 dispose:)
				(gLongSong fade: 127 10 10 0)
				(gLongSong2 fade:)
				(self dispose:)
			)
		)
	)
)

