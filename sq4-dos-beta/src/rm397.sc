;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 397)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm397 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(class rssScript of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if local2
			(if (= temp0 ((User curEvent:) type:))
				(Display 397 0 dsRESTOREPIXELS local2)
				(= local2 0)
				(= seconds 0)
				(= cycles 1)
			)
			(= temp0 evNULL)
		)
	)
)

(instance rm397 of SQRoom
	(properties
		picture 397
		style 30
		south 395
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 306 189 294 176 197 176 181 145 297 145 269 113 254 113 223 117 93 117 66 112 41 112 31 144 133 144 114 178 17 178 7 189
					yourself:
				)
		)
		(HandsOn)
		(self setRegions: 700) ; mall
		(super init:)
		(displayCase init:)
		(shelf1 init:)
		(box init:)
		(shelf2 init:)
		(bin1 init:)
		(bin2 init:)
		(gEgo posn: 160 180 init:)
		(if (== gPrevRoomNum 398)
			(gEgo posn: 127 163)
		)
		(clerkHead posn: 161 70 setPri: 8 init:)
		(clerk posn: 160 85 init:)
		(if (== gPrevRoomNum 395)
			(gCurRoom setScript: walkIn)
		else
			(gCurRoom setScript: clerkScript)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) $4000)
				(!= global160 0)
				(!= local0 1)
				(not local6)
			)
			(= local0 1)
			(gCurRoom setScript: yell)
		)
		(if
			(and
				(& (gEgo onControl: 1) $2000)
				(!= global160 0)
				(!= local1 1)
				(not local6)
			)
			(= local1 1)
			(gCurRoom setScript: yell)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0200)
				(not local4)
				(!= global160 0)
				(not local6)
			)
			(= local4 1)
			(gCurRoom setScript: buyBox)
		)
		(if (and (not (& (gEgo onControl: 1) $0200)) (== local4 1))
			(= local4 0)
		)
	)

	(method (handleEvent)
		(Print 397 1) ; "event"
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 160 200)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 160 170 self)
			)
			(2
				(HandsOn)
				(client setScript: clerkScript)
			)
		)
	)
)

(instance buyBox of rssScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerk setScript: talk)
				(HandsOff)
				(= cycles 20)
			)
			(1
				(clerk setScript: 0 setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 cel: 0)
				(= local2
					(proc0_12
						{"That will be 5 Buckazoids."}
						67
						2
						5
						30
						1
						28
						global135
						29
						global129
					)
				)
				(= seconds 5)
			)
			(2
				(Display 397 0 dsRESTOREPIXELS local2)
				(= local2 0)
				(clerk setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 cel: 0)
				(clerk setScript: 0)
				(HandsOn)
				(= cycles 1)
			)
		)
	)
)

(instance yell of rssScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerk setScript: talk)
				(gEgo setMotion: 0)
				(HandsOff)
				(= cycles 20)
			)
			(1
				(clerk setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 cel: 0)
				(= cycles 1)
			)
			(2
				(if (and (== local0 1) (== local1 1))
					(= local2
						(proc0_12
							{"I would'nt try that if I was you."}
							67
							2
							5
							30
							1
							28
							global135
							29
							global129
						)
					)
				else
					(= local2
						(proc0_12
							{"Excuse me sir? Would you like to pay for that?"}
							67
							2
							5
							30
							1
							28
							global135
							29
							global129
						)
					)
				)
				(= seconds 7)
			)
			(3
				(Display 397 0 dsRESTOREPIXELS local2)
				(= local2 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance talk2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(1
				(otherGuy
					init:
					loop: 1
					illegalBits: 0
					posn: 250 130
					setStep: 4 2
					setCycle: Fwd
					setMotion: MoveTo 10 130
				)
				(= cycles 10)
			)
			(2
				(myGuy
					init:
					loop: 2
					illegalBits: 0
					posn: 300 115
					setCycle: Fwd
					setMotion: MoveTo 120 115 self
				)
			)
			(3
				(otherGuy setCycle: 0)
				(myGuy setMotion: 0 view: 409 loop: 1 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(myGuy
					view: 408
					loop: 1
					setMotion: MoveTo 0 115 self
					setCycle: Fwd
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerkHead cycleSpeed: 0 loop: 1 setCycle: Fwd)
				(clerk setCycle: Fwd)
			)
		)
	)
)

(instance clerkScript of rssScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 0)
				(HandsOff)
				(clerk setScript: talk)
				(cond
					((and (!= global160 0) (== gPrevRoomNum 398))
						(= seconds 5)
					)
					((== gPrevRoomNum 398)
						(= seconds 3)
					)
					(else
						(= seconds 5)
					)
				)
			)
			(1
				(clerk setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 stopUpd: cel: 0)
				(= cycles 2)
			)
			(2
				(cond
					((and (!= global160 0) (== gPrevRoomNum 398))
						(= local2
							(proc0_12
								{"Ah, I see you've made a selection\nfrom our box of shi..er, bargain bin."}
								67
								2
								5
								30
								1
								28
								global135
								29
								global129
							)
						)
						(= seconds 9)
					)
					((== gPrevRoomNum 398)
						(= local2
							(proc0_12
								{"Didn't find anything you liked eh?"}
								67
								2
								5
								28
								0
								30
								1
								28
								global135
								29
								global129
							)
						)
						(= seconds 9)
					)
					(else
						(= local2
							(proc0_12
								{"Sorry, but the crowd completely cleaned out my stock of Sierra software. The only thing that's left is boring home and business applications software along with a few inferior games. But feel free to look around anyway."}
								67
								2
								5
								70
								315
								30
								1
								28
								global135
								29
								global129
							)
						)
						(= seconds 20)
					)
				)
			)
			(3
				(Display 397 0 dsRESTOREPIXELS local2)
				(= local2 0)
				(HandsOn)
				(clerk setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance birdy of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= (gEgo heading:) 180)
			(clerk loop: 0 cel: 0)
			(clerkHead loop: 2 setCycle: RandCycle cycleSpeed: 20)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerkHead setCycle: 0 loop: 3 cel: 1)
				(clerk setCycle: 0 loop: 3 cel: 0)
				(= seconds 3)
			)
			(1
				(clerkHead loop: 4 cycleSpeed: 0 setCycle: Fwd)
				(clerk loop: 0 cel: 0)
				(= seconds (Random 2 4))
			)
			(2
				(clerkHead loop: 2 setCycle: RandCycle cycleSpeed: 20)
				(= seconds 10)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance clerk of Prop
	(properties
		description {sales clerk}
		view 397
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (self script:))
				(== (clerkHead loop:) 2)
				(== (gEgo heading:) 180)
				(== (Random 0 500) 10)
			)
			(gCurRoom setScript: birdy)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(gCurRoom setScript: clerkScript)
			)
			(6 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(if (not global160)
							(Print 397 2) ; "*** You should pick something out before you give money to the clerk."
						else
							(if local6
								(Print 397 3) ; "*** You have already paid the clerk."
							else
								(Print 397 4) ; "'Thank you.'"
								(-= gBuckazoidCount 5)
								(= local6 1)
								(gEgo get: 9) ; hintbook
								(SetFlag 33)
							)
							(= local6 1)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(2 ; Smell
				(Print 397 5) ; "*** Ah the distinctive aroma of Centauri Moon no. 5."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clerkHead of Prop
	(properties
		description {sales clerk}
		view 397
		loop 1
	)

	(method (doit)
		(super doit:)
		(if (and (not (self script:)) (not (gCurRoom script:)))
			(cond
				((> (gEgo y:) 168)
					(self setCycle: 0 loop: 1 cel: 11)
				)
				(
					(and
						(not (& (gEgo onControl: 1) $0200))
						(not (self cycler:))
					)
					(self setCycle: RandCycle loop: 2 cycleSpeed: 20)
				)
				((& (gEgo onControl: 1) $0200)
					(self setCycle: 0 loop: 1 cel: 0)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(gCurRoom setScript: clerkScript)
			)
			(6 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(if (not global160)
							(Print 397 2) ; "*** You should pick something out before you give money to the clerk."
						else
							(if local6
								(Print 397 3) ; "*** You have already paid the clerk."
							else
								(Print 397 4) ; "'Thank you.'"
								(gEgo get: 9) ; hintbook
								(-= gBuckazoidCount 5)
								(SetFlag 33)
								(= local6 1)
							)
							(= local6 1)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(2 ; Smell
				(Print 397 5) ; "*** Ah the distinctive aroma of Centauri Moon no. 5."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 135 162 self)
			)
			(1
				(gEgo loop: 5)
				(= cycles 5)
			)
			(2
				(gCurRoom newRoom: 398)
			)
		)
	)
)

(instance displayCase of Feature
	(properties
		x 157
		y 94
		nsTop 80
		nsLeft 45
		nsBottom 109
		nsRight 269
		description {display case}
		sightAngle 90
		lookStr {*** The clerk was right, there is only boring applications software left.}
	)
)

(instance bin1 of Feature
	(properties
		x 89
		y 135
		nsTop 129
		nsLeft 68
		nsBottom 141
		nsRight 111
		description {bargain bin}
		sightAngle 90
		lookStr {** A bargain bin contains discount software.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 397 6) ; "test 2"
				(clerk setScript: clerkScript)
			)
			(4 ; Do
				(gCurRoom setScript: goBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bin2 of Feature
	(properties
		x 78
		y 144
		nsTop 141
		nsLeft 49
		nsBottom 148
		nsRight 107
		description {bargain bin}
		sightAngle 90
		lookStr {** A bargain bin contains discount software.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 397 6) ; "test 2"
				(clerk setScript: clerkScript)
			)
			(4 ; Do
				(gCurRoom setScript: goBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shelf1 of Feature
	(properties
		x 161
		y 58
		nsTop 42
		nsLeft 63
		nsBottom 74
		nsRight 260
		description {display shelf}
		sightAngle 90
		lookStr {*** The clerk was right, there is only boring applications software left.}
	)
)

(instance otherGuy of Actor
	(properties
		view 382
	)
)

(instance myGuy of Actor
	(properties
		view 408
	)
)

(instance box of Feature
	(properties
		x 307
		y 35
		nsTop 30
		nsLeft 296
		nsBottom 40
		nsRight 319
		description {box}
		sightAngle 90
		lookStr {}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Taste
				(if (not (gCurRoom script:))
					(gCurRoom setScript: talk2)
				)
			)
		)
	)
)

(instance shelf2 of Feature
	(properties
		x 53
		y 63
		nsTop 51
		nsLeft 45
		nsBottom 76
		nsRight 61
		description {display shelf}
		sightAngle 90
		lookStr {*** The clerk was right, there is only boring applications software left.}
	)
)

