;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 397)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Motion)
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
	[local8 300]
)

(instance rm397 of SQRoom
	(properties
		picture 397
		style 10
		south 395
		lookStr 1 ; "The software selection seems to be pretty slim, except for the bargain bin near the entrance."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 1) ; "The software selection seems to be pretty slim, except for the bargain bin near the entrance."
			)
			(6 ; Smell
				(proc0_16)
			)
			(7 ; Taste
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
		(displayCase init:)
		(shelf1 init:)
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
				(self dispose:)
			)
		)
	)
)

(instance clerkScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(cond
					((and (not (IsFlag 31)) (!= global160 0) (== gPrevRoomNum 398))
						(tCLERK say: 5 self) ; "Ah, I see you've made a selection  from our box of slop..er, bargain bin."
					)
					((and (== gPrevRoomNum 398) (IsFlag 31))
						(tCLERK say: 6 self) ; "I'm sure you'll be satisfied with your selection."
					)
					((== gPrevRoomNum 398)
						(tCLERK say: 7 self) ; "Didn't find anything you liked, eh?"
					)
					(else
						(tCLERK say: 8 self) ; "Sorry, but the crowd completely cleaned out my stock of Sierra software. The only thing that's left is boring home and business applications software along with a few inferior games. But feel free to look around anyway."
					)
				)
			)
			(2
				(if (!= gPrevRoomNum 398)
					(= temp0 (Random 0 2))
					(tCLERK
						say:
							(switch temp0
								(0 9)
								(1 10)
								(2 11)
							)
							self
					)
					(= seconds 30)
				else
					(self cue:)
				)
			)
			(3
				(HandsOn)
				(clerkHead setCycle: 0 stopUpd: cel: 0)
				(clerk setCycle: 0 cel: 0 setScript: 0)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance buyBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tCLERK say: 1 self) ; "That will be 5 Buckazoids."
			)
			(1
				(HandsOn)
				(clerkHead setCycle: 0 cel: 0)
				(clerk setCycle: 0 cel: 0 setScript: 0)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance yell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(HandsOff)
				(cond
					((and (== local0 1) (== local1 1))
						(tCLERK say: 2 self) ; "I wouldn't try that if I was you."
					)
					((OneOf (gEgo view:) 373 374)
						(tCLERK say: 3 self) ; "Excuse me, ma'am! Would you like to pay for that?"
					)
					(else
						(tCLERK say: 4 self) ; "Excuse me, sir! Would you like to pay for that?"
					)
				)
			)
			(1
				(clerk setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 cel: 0)
				(HandsOn)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance talk2 of Script ; UNUSED
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

(instance sayThankYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tCLERK say: 12 self) ; "Heh heh. Thank You."
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance clerk of Sq4Prop
	(properties
		view 397
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: clerkScript)
			)
			(8 ; buckazoid
				(cond
					((not global160)
						(gNarrator say: 2) ; "You should pick something out before you give money to the clerk."
					)
					((IsFlag 31)
						(gNarrator say: 3) ; "You have already paid the clerk."
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
			(1 ; Look
				(gNarrator say: 4) ; "The clerk is keeping his eye on you."
			)
			(6 ; Smell
				(gNarrator say: 5) ; "Ah! The distinctive aroma of Centauri Moon No. 5."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clerkHead of Sq4Prop
	(properties
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
				(self setCycle: RandCycle loop: 2 cycleSpeed: 126)
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

(instance displayCase of Sq4Feature
	(properties
		x 157
		y 94
		nsTop 80
		nsLeft 45
		nsBottom 109
		nsRight 269
		sightAngle 90
		lookStr 6 ; "The clerk was right. Only boring applications software remains."
	)
)

(instance bin1 of Sq4Feature
	(properties
		x 89
		y 135
		nsTop 129
		nsLeft 68
		nsBottom 141
		nsRight 111
		sightAngle 90
		lookStr 7 ; "A bargain bin containing discount software."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: goBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bin2 of Sq4Feature
	(properties
		x 78
		y 144
		nsTop 141
		nsLeft 49
		nsBottom 148
		nsRight 107
		sightAngle 90
		lookStr 7 ; "A bargain bin containing discount software."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: goBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shelf1 of Sq4Feature
	(properties
		x 161
		y 58
		nsTop 42
		nsLeft 63
		nsBottom 74
		nsRight 260
		sightAngle 90
		lookStr 6 ; "The clerk was right. Only boring applications software remains."
	)
)

(instance otherGuy of Sq4Actor
	(properties
		view 382
	)
)

(instance myGuy of Sq4Actor
	(properties
		view 408
	)
)

(instance shelf2 of Sq4Feature
	(properties
		x 53
		y 63
		nsTop 51
		nsLeft 45
		nsBottom 76
		nsRight 61
		sightAngle 90
		lookStr 6 ; "The clerk was right. Only boring applications software remains."
	)
)

(instance tROG of Sq4Talker ; UNUSED
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 22
		mouthOffsetY 31
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tCLERK of Sq4Talker
	(properties
		z 400
		noun 9
		view 1708
		talkerNum 9
		mouthOffsetX 21
		mouthOffsetY 36
		eyeOffsetX 25
		eyeOffsetY 18
	)
)

