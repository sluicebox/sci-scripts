;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 397)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm397 0
)

(local
	local0
	local1
	[local2 2]
	local4
	[local5 2]
	local7
	local8
)

(instance rm397 of SQRoom
	(properties
		picture 397
		style 10
		south 395
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (gCurRoom script:)
					(proc0_16)
				else
					(Print 397 0) ; "The software selection seems to be pretty slim, except for the bargain bin near the entrance."
				)
			)
			(11 ; Smell
				(proc0_16)
			)
			(10 ; Taste
				(proc0_16)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(= local7 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 306 189 298 180 197 176 181 145 297 145 269 113 254 113 223 117 93 117 66 112 41 112 31 144 133 144 114 178 17 178 7 189
					yourself:
				)
		)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(HandsOn)
		(clerkHead posn: 161 70 setPri: 8 init:)
		(clerk posn: 160 85 init:)
		(super init:)
		(self setRegions: 700) ; mall
		(birdyFeature init:)
		(displayCase init:)
		(shelf1 init:)
		(box init:)
		(shelf2 init:)
		(bin1 init:)
		(bin2 init:)
		(gEgo x: 160 y: 180 init:)
		(if (== gPrevRoomNum 398)
			(gEgo posn: 127 163)
		)
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
				(not (IsFlag 31))
			)
			(= local0 1)
			(gCurRoom setScript: yell)
		)
		(if
			(and
				(& (gEgo onControl: 1) $2000)
				(!= global160 0)
				(!= local1 1)
				(not (IsFlag 31))
			)
			(= local1 1)
			(gCurRoom setScript: yell)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0200)
				(not local4)
				(!= global160 0)
				(not (IsFlag 31))
			)
			(= local4 1)
			(gCurRoom setScript: buyBox)
		)
		(if (and (not (& (gEgo onControl: 1) $0200)) (== local4 1))
			(= local4 0)
		)
	)

	(method (dispose)
		(DisposeScript 941)
		(= gUseSortedFeatures local7)
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

(instance buyBox of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(clerk setScript: talk)
				(self
					save1:
						(proc0_12
							{"That will be 5 Buckazoids."}
							67
							2
							5
							30
							1
							28
							(proc0_18 global135 global136)
							29
							global129
						)
				)
				(= seconds 5)
			)
			(1
				(clerk setScript: 0 setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 cel: 0)
				(self restore:)
				(clerk setScript: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance yell of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerk setScript: talk)
				(gEgo setMotion: 0)
				(HandsOff)
				(if (and (== local0 1) (== local1 1))
					(self
						save1:
							(proc0_12
								{"I wouldn't try that if I was you."}
								67
								2
								5
								30
								1
								28
								(proc0_18 global135 global136)
								29
								global129
								70
								317
							)
					)
				else
					(self
						save1:
							(if (OneOf (gEgo view:) 373 374)
								(proc0_12
									{"Excuse me, ma'am! Would you like to pay for that?"}
									67
									2
									5
									30
									1
									28
									(proc0_18 global135 global136)
									29
									global129
									70
									317
								)
							else
								(proc0_12
									{"Excuse me, sir! Would you like to pay for that?"}
									67
									2
									5
									30
									1
									28
									(proc0_18 global135 global136)
									29
									global129
									70
									317
								)
							)
					)
				)
				(= seconds 7)
			)
			(1
				(clerk setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 cel: 0)
				(self restore:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance talk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerkHead cycleSpeed: 0 setLoop: 1 setCycle: Fwd)
				(clerk setCycle: Fwd)
			)
		)
	)
)

(instance clerkScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(clerk setScript: talk)
				(cond
					((and (not (IsFlag 31)) (!= global160 0) (== gPrevRoomNum 398))
						(self
							save1:
								(proc0_12
									{"Ah, I see you've made a selection from our box of slop..er, bargain bin."}
									67
									2
									5
									30
									1
									28
									(proc0_18 global135 global136)
									29
									global129
									70
									210
								)
						)
						(= seconds 9)
					)
					((and (== gPrevRoomNum 398) (IsFlag 31))
						(self
							save1:
								(proc0_12
									{"I'm sure you'll be satisfied with your selection."}
									67
									2
									5
									28
									0
									30
									1
									28
									(proc0_18 global135 global136)
									29
									global129
									70
									210
								)
						)
						(= seconds 9)
					)
					((== gPrevRoomNum 398)
						(self
							save1:
								(proc0_12
									{"Didn't find anything you liked, eh?"}
									67
									2
									5
									28
									0
									30
									1
									28
									(proc0_18 global135 global136)
									29
									global129
									70
									317
								)
						)
					)
					(else
						(self
							save1:
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
									(proc0_18 global135 global136)
									29
									global129
								)
						)
						(= seconds 20)
					)
				)
			)
			(1
				(if (!= gPrevRoomNum 398)
					(self restore:)
					(self
						save1:
							(proc0_12
								(switch (Random 0 2)
									(0 {"So, are ya looking for a good data base? We've got one coming in next week."})
									(1 {"Hey, have you seen the newest time travel simulator? Neither have I. I'm sure we're getting some in soon."})
									(2 {"If you're here to return something, forget it. We have a strict 'No Returns' policy. I'd like to help you out, guy. But you know how corporations are."})
								)
								67
								2
								5
								70
								315
								30
								1
								28
								(proc0_18 global135 global136)
								29
								global129
							)
					)
					(= seconds 30)
				else
					(self cue:)
				)
			)
			(2
				(clerk setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 stopUpd: cel: 0)
				(self restore:)
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
		(if (!= (gEgo loop:) 2)
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
				(= cycles (Random 20 40))
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

(instance sayThankYou of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self
					save1:
						(proc0_12
							{"Thank You."}
							67
							2
							5
							30
							1
							28
							(proc0_18 global135 global136)
							29
							global129
						)
				)
				(= seconds 3)
			)
			(1
				(HandsOn)
				(self restore:)
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
				(== (gEgo loop:) 2)
				(== (Random 0 100) 1)
				local8
			)
			(gCurRoom setScript: birdy)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(gCurRoom setScript: clerkScript)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(cond
							((not global160)
								(Print 397 1) ; "You should pick something out before you give money to the clerk."
							)
							((IsFlag 31)
								(Print 397 2) ; "You have already paid the clerk."
							)
							((< gBuckazoidCount 5)
								(gCurRoom setScript: buyBox)
							)
							(else
								(self setScript: sayThankYou)
								(if (< (-= gBuckazoidCount 5) 1)
									(gEgo put: 0) ; buckazoid
								)
								(SetScore 85 5)
								(SetFlag 31)
							)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(2 ; Look
				(Print 397 3) ; "It looks like the clerk is keeping his eye on you."
			)
			(11 ; Smell
				(Print 397 4) ; "Ah! The distinctive aroma of Centauri Moon No. 5."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clerkHead of Prop
	(properties
		description {sales clerk#commesso}
		view 397
		loop 1
	)

	(method (doit)
		(super doit:)
		(cond
			((or (clerk script:) (gCurRoom script:)) 0)
			((> (gEgo y:) 168)
				(self setCycle: 0 loop: 1 cel: 11)
			)
			((and (not (& (gEgo onControl: 1) $0200)) (not cycler))
				(self setCycle: RandCycle loop: 2 cycleSpeed: 20)
			)
			((& (gEgo onControl: 1) $0200)
				(self setCycle: 0 loop: 1 cel: 0)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(clerk doVerb: theVerb invItem)
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 397 5) ; "The clerk was right. Only boring applications software remains."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 397 6) ; "A bargain bin containing discount software."
			)
			(3 ; Do
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 397 6) ; "A bargain bin containing discount software."
			)
			(3 ; Do
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 397 5) ; "The clerk was right. Only boring applications software remains."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance otherGuy of Actor ; UNUSED
	(properties
		view 382
	)
)

(instance myGuy of Actor ; UNUSED
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
		description {wall}
		sightAngle 90
		lookStr {}
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
		lookStr {The clerk was right. Only boring applications software remains.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 397 5) ; "The clerk was right. Only boring applications software remains."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance birdyFeature of Feature
	(properties
		x 9
		y 33
		nsTop 28
		nsBottom 38
		nsRight 19
		description {wall}
		sightAngle 90
		lookStr {}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(if (not (gCurRoom script:))
					(Print 397 7) ; "Ah! Yeaa!"
					(++ local8)
					(self dispose:)
				)
			)
		)
	)
)

