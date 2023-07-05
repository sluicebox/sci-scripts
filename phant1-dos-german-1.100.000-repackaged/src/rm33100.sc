;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm33100 0
)

(local
	local0
)

(instance rm33100 of ScaryRoom
	(properties
		picture 33530
		stepSound 1
	)

	(method (init)
		(gGDacSound number: 9030 play:)
		(gEgo init: ignoreActors: 1 normalize: 6 setScale: 0 posn: 84 117)
		(switch gPrevRoomNum
			(900
				(if (not (IsFlag 172))
					(doggie
						init:
						setHotspot: 4 3 28 ; Do, Move, invDogBone
						setCycle: Fwd
						cycleSpeed: 10
					)
				)
				(gGame handsOn:)
			)
			(33000
				(= picture 33500)
				(self setScript: exitHouseScr)
			)
			(33200
				(= picture 33500)
				(self setScript: exitHouseScr)
			)
			(33300
				(= picture 33500)
				(self setScript: exitHouseScr)
			)
		)
		(Load 140 33021 33022) ; WAVE
		(Lock 140 33022 1) ; WAVE
		(Lock 140 33021 1) ; WAVE
		(if
			(and
				(not (OneOf gPrevRoomNum 900 33000 33300))
				(not (IsFlag 172))
			)
			(= picture 33210)
			(gCurRoom setScript: dogAngryScr)
		else
			(if
				(and
					(not (and (IsFlag 173) (== gChapter 3)))
					(not (and (IsFlag 156) (== gChapter 2)))
					(not
						(and
							(== gChapter 2)
							(not (IsFlag 250))
							(not (IsFlag 162))
							(IsFlag 144)
						)
					)
					(IsFlag 172)
					(not (IsFlag 206))
				)
				(gate init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
			)
			(if (!= (gCurRoom script:) exitHouseScr)
				(mailBoxView2 init:)
				(if (!= gPrevRoomNum 900)
					(self setScript: (ScriptID 0 5)) ; takeLastStep
				)
			)
		)
		(southExit init: 12)
		(super init:)
	)

	(method (dispose)
		(Lock 140 33021 0) ; WAVE
		(Lock 140 33022 0) ; WAVE
		(super dispose:)
	)
)

(instance dogAngryScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1910 -8 -31)
					(SetFlag 100)
				)
				(1
					(doggie
						init:
						setHotspot: 4 3 28 ; Do, Move, invDogBone
						setCycle: Fwd
						cycleSpeed: 10
					)
					(mailBoxView2 init:)
					(gCurRoom drawPic: 33530)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 100)
					(proc1111_6)
					(if (not (gCast contains: mailBoxView2))
						(mailBoxView2 init:)
					)
					(gCurRoom drawPic: 33530)
					(if (not (gCast contains: doggie))
						(doggie
							init:
							setHotspot: 4 3 28 ; Do, Move, invDogBone
							setCycle: Fwd
							cycleSpeed: 10
						)
					)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance openGate of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo hide:)
					(proc1111_7 5831 31 2 gEgo 2 1)
					(mailBoxView2 dispose:)
					(mailBoxView init:)
					(gCurRoom drawPic: 33500)
				)
				(1
					(gCurRoom newRoom: 33200)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 33200)
				)
			)
		)
	)
)

(instance giveBoneScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo put: 20) ; invDogBone
					(doggie loop: 0 cel: 0 setCycle: End self)
				)
				(1
					(gate init: setHotspot: 4 3) ; Do, Move
					(proc1111_7 2980 -25 -39 gEgo 200)
					(gateView init:)
					(mailBoxView init:)
					(mailBoxView2 dispose:)
					(doggie dispose:)
					(gCurRoom drawPic: 33500)
				)
				(2
					(gEgo setScale: 0 normalize: 6 show:)
					(mailBoxView dispose:)
					(gateView dispose:)
					(mailBoxView2 init:)
					(gate init: setHotspot: 4 3) ; Do, Move
					(gCurRoom drawPic: 33530)
					(SetFlag 172)
					(gGame handsOn: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(proc1111_6)
					(if (barkSnd handle:)
						(barkSnd stop:)
					)
					(if (barkSnd2 handle:)
						(barkSnd stop:)
					)
					(if (gCast contains: mailBoxView)
						(mailBoxView dispose:)
					)
					(if (gCast contains: gateView)
						(gateView dispose:)
					)
					(if (not (gCast contains: mailBoxView2))
						(mailBoxView2 init:)
					)
					(if (gCast contains: doggie)
						(doggie dispose:)
					)
					(gCurRoom drawPic: 33530)
					(gEgo put: 20 setScale: 0 normalize: 6 show:) ; invDogBone
					(gate init: setHotspot: 4 3) ; Do, Move
					(SetFlag 172)
					(gGame handsOn: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance exitHouseScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo hide:)
					(mailBoxView init:)
					(if (== gPrevRoomNum 33200)
						(proc1111_7 5832 14 2 gEgo -1 1)
					else
						(proc1111_7 5830 14 2 gEgo -1 1)
					)
				)
				(1
					(gGDacSound setVol: 127)
					(gCurRoom newRoom: 34100)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gGDacSound setVol: 127)
					(gCurRoom newRoom: 34100)
				)
			)
		)
	)
)

(instance sDoBox of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1930 39 11)
					(gateView init:)
					(mailBoxView2 dispose:)
					(if (gCast contains: doggie)
						(doggie
							view: 33501
							loop: 0
							cel: 0
							x: 88
							y: 130
							setCycle: Fwd
							cycleSpeed: 6
						)
					)
					(gCurRoom drawPic: 33500)
				)
				(1
					(gEgo hide:)
					(gateView dispose:)
					(doggie hide:)
					(if (not (IsFlag 321))
						(letter init:)
						(gCurRoom drawPic: 33520)
						(= seconds 7)
					else
						(if (not (gCast contains: mailBoxView2))
							(mailBoxView2 init:)
						)
						(if (gCast contains: doggie)
							(doggie
								view: 33530
								x: 93
								y: 80
								loop: 2
								show:
								cel: 0
								setCycle: Fwd
								cycleSpeed: 10
							)
						)
						(gEgo show:)
						(gCurRoom drawPic: 33530)
						(= seconds 2)
					)
				)
				(2
					(gEgo show:)
					(if (not (IsFlag 321))
						(letter dispose:)
						(= local0 1)
						(SetFlag 321)
						(proc1111_7 1931 39 11)
						(if (not (gCast contains: gateView))
							(gateView init:)
						)
						(if (gCast contains: mailBoxView2)
							(mailBoxView2 dispose:)
						)
						(if (gCast contains: doggie)
							(doggie show:)
						)
						(gCurRoom drawPic: 33500)
					else
						(self cue:)
					)
				)
				(3
					(if (gCast contains: gateView)
						(gateView dispose:)
					)
					(if (not (gCast contains: mailBoxView2))
						(mailBoxView2 init:)
					)
					(mailBoxView2 setHotspot: 0)
					(if (gCast contains: doggie)
						(doggie
							view: 33530
							x: 93
							y: 80
							loop: 2
							show:
							cel: 0
							setCycle: Fwd
							cycleSpeed: 10
						)
					)
					(gCurRoom drawPic: 33530)
					(gGame handsOn: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo show:)
					(proc1111_6)
					(if (gCast contains: gateView)
						(gateView dispose:)
					)
					(if (gCast contains: mailBoxView)
						(mailBoxView dispose:)
					)
					(if (not (gCast contains: mailBoxView2))
						(mailBoxView2 init:)
					)
					(if (gCast contains: letter)
						(letter dispose:)
					)
					(mailBoxView2 setHotspot: 0)
					(if (gCast contains: doggie)
						(doggie
							view: 33530
							x: 93
							y: 80
							loop: 2
							show:
							cel: 0
							setCycle: Fwd
							cycleSpeed: 10
						)
					)
					(gCurRoom drawPic: 33530)
					(if (not (IsFlag 321))
						(= local0 1)
						(SetFlag 321)
					)
					(= global115 0)
					(gGame handsOn: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGoodDog of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1940 61 -40)
					(gateView init:)
					(mailBoxView init:)
					(mailBoxView2 dispose:)
					(doggie dispose:)
					(gCurRoom drawPic: 33500)
				)
				(1
					(gateView dispose:)
					(mailBoxView dispose:)
					(doggie
						init:
						setHotspot: 4 3 28 ; Do, Move, invDogBone
						setCycle: Fwd
						cycleSpeed: 10
					)
					(mailBoxView2 init:)
					(gCurRoom drawPic: 33530)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gateView dispose:)
					(mailBoxView dispose:)
					(proc1111_6)
					(if (not (gCast contains: mailBoxView2))
						(mailBoxView2 init:)
					)
					(if (not (gCast contains: doggie))
						(doggie
							init:
							setHotspot: 4 3 28 ; Do, Move, invDogBone
							setCycle: Fwd
							cycleSpeed: 10
						)
					)
					(gCurRoom drawPic: 33530)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance mailBoxView of View
	(properties
		x 145
		y 53
		view 33500
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance mailBoxView2 of View
	(properties
		x 56
		y 77
		view 33530
		loop 1
	)

	(method (init)
		(super init:)
		(if (and (< gChapter 3) (not (IsFlag 321)))
			(self setHotspot: 4 3) ; Do, Move
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (or (> gChapter 2) (IsFlag 321))
				(super doVerb: theVerb)
			else
				(gCurRoom setScript: sDoBox)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gateView of View
	(properties
		x 85
		y 115
		view 33500
	)
)

(instance doggie of Prop
	(properties
		x 93
		y 80
		view 33530
		loop 2
	)

	(method (doVerb theVerb)
		(dogFeat doVerb: theVerb)
	)

	(method (doit)
		(cond
			(global207 0)
			(
				(and
					(== loop 2)
					(== view 33530)
					(OneOf cel 3 7 9 15 19)
					(not (barkSnd handle:))
					(not (barkSnd2 handle:))
				)
				(if (< (Random 0 10) 5)
					(barkSnd play: setLoop: 1)
				else
					(barkSnd2 play: setLoop: 1)
				)
			)
			(
				(and
					(== view 33501)
					(== loop 0)
					(not (barkSnd handle:))
					(not (barkSnd2 handle:))
					(OneOf cel 3 7 18 22 36 46 50 51)
				)
				(if (< (Random 0 10) 5)
					(barkSnd play: setLoop: 1)
				else
					(barkSnd2 play: setLoop: 1)
				)
			)
		)
		(super doit:)
	)
)

(instance barkSnd of Sound
	(properties
		number 33021
	)
)

(instance barkSnd2 of Sound
	(properties
		number 33022
	)
)

(instance letter of View
	(properties
		x 136
		y 102
		view 33520
	)
)

(instance dogFeat of Feature
	(properties
		nsLeft 71
		nsTop 74
		nsRight 145
		nsBottom 128
		y 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(28 ; invDogBone
				(gGame handsOff:)
				(gCurRoom setScript: giveBoneScr)
			)
			(4 ; Do
				(gCurRoom setScript: sGoodDog)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gate of Feature
	(properties
		nsLeft 74
		nsTop 74
		nsRight 116
		nsBottom 112
		x 95
		y 93
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 172)
					(gGame handsOff:)
					(gCurRoom setScript: openGate)
				else
					(gGame handsOff:)
					(gCurRoom setScript: dogAngryScr)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mailbox of Feature ; UNUSED
	(properties
		nsLeft 54
		nsTop 66
		nsRight 66
		nsBottom 77
		sightAngle 40
		x 60
		y 71
	)

	(method (doVerb theVerb)
		(if (and (not (IsFlag 321)) (< gChapter 4) (== theVerb 4)) ; Do
			(gCurRoom setScript: sDoBox)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 100
		nsRight 319
		nsBottom 128
		approachX 60
		approachY 128
		nextRoom 34100
		appYOffset 20
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGDacSound setVol: 127)
		)
		(super doVerb: theVerb)
	)
)

