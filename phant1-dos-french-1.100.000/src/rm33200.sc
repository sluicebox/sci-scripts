;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm33200 0
)

(instance rm33200 of ScaryRoom
	(properties
		picture 33210
		stepSound 1
	)

	(method (init)
		(proc1111_6)
		(if (not (gGDacSound handle:))
			(gGDacSound number: 9030 setLoop: -1 play: setVol: 50)
		else
			(gGDacSound setVol: 50)
		)
		(gEgo
			setScaler: Scaler 115 115 200 0
			init:
			posn: 160 110
			normalize: 6
		)
		(if
			(or
				(and (IsFlag 162) (not (IsFlag 156)))
				(and (not (IsFlag 250)) (not (IsFlag 144)))
				(!= gChapter 2)
			)
			(door init:)
		)
		(southExit init: 12)
		(super init: &rest)
		(gGame handsOn:)
	)

	(method (dispose)
		(ClearFlag 248)
		(super dispose:)
	)
)

(instance scene300Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 3000)
					(door dispose:)
					(gCurRoom drawPic: 33220)
				)
				(1
					(if (!= gChapter 2)
						(door init:)
					)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(if (!= gChapter 2)
						(door init:)
					)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene301Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 3010)
					(door dispose:)
					(gCurRoom drawPic: 33220)
				)
				(1
					(if (!= gChapter 2)
						(door init:)
					)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (!= gChapter 2)
						(door init:)
					)
					(gCurRoom drawPic: 33210)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene392Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 3920)
					(gCurRoom drawPic: 33220)
				)
				(1
					(door dispose:)
					(ethelFeat
						init:
						setHotspot:
							4 ; Do
							3 ; Move
							0
							8 ; invLibKey
							6 ; invMoney
							7 ; invNail
							9 ; invNewspaper
							10 ; invPoker
							11 ; invHammer
							12 ; invStairKey
							13 ; invVampBook
							14 ; invMatch
							15 ; invTarot
							16 ; invBrooch
							17 ; invPhoto
							18 ; invLensPiece
							19 ; invDrainCln
							20 ; invCrucifix
							22 ; invBeads
							23 ; invSpellBook
							25 ; invXmasOrn
							26 ; invStone
							27 ; invCutter
							28 ; invDogBone
							34 ; invFigurine
						approachVerbs: 0
					)
					(gGame handsOn:)
					(gCurRoom setScript: sWait)
				)
			)
		else
			(switch (= state newState)
				(0
					(door dispose:)
					(ethelFeat
						init:
						setHotspot:
							4 ; Do
							3 ; Move
							0
							8 ; invLibKey
							6 ; invMoney
							7 ; invNail
							9 ; invNewspaper
							10 ; invPoker
							11 ; invHammer
							12 ; invStairKey
							13 ; invVampBook
							14 ; invMatch
							15 ; invTarot
							16 ; invBrooch
							17 ; invPhoto
							18 ; invLensPiece
							19 ; invDrainCln
							20 ; invCrucifix
							22 ; invBeads
							23 ; invSpellBook
							25 ; invXmasOrn
							26 ; invStone
							27 ; invCutter
							28 ; invDogBone
							34 ; invFigurine
						approachVerbs: 0
					)
					(= global115 0)
					(gGame handsOn:)
					(gCurRoom setScript: sWait)
				)
			)
		)
	)
)

(instance sWait of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 248)
					(proc1111_6)
					(proc1111_7 3952 0 0 gEgo -1 1)
					(gCurRoom drawPic: 33230)
				)
				(1
					(gGame handsOn:)
					(southExit dispose:)
					(= seconds 15)
				)
				(2
					(gGame handsOff:)
					(ethelFeat dispose:)
					(door init: approachVerbs: 0)
					(if (== gChapter 6)
						(proc1111_7 5670)
					else
						(proc1111_7 3921)
					)
					(gCurRoom drawPic: 33220)
				)
				(3
					(gEgo show: normalize: 6)
					(ClearFlag 248)
					(southExit init: 12)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(ClearFlag 248)
					(gEgo show: normalize: 6)
					(if (gFeatures contains: ethelFeat)
						(ethelFeat dispose:)
						(door init: approachVerbs: 0)
					)
					(southExit init: 12)
					(gCurRoom drawPic: 33210)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene393Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(southExit init: 12)
					(proc1111_7 3931)
					(gCurRoom drawPic: 33220)
				)
				(1
					(ethelFeat dispose:)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(gEgo show: normalize: 6)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (gFeatures contains: ethelFeat)
						(ethelFeat dispose:)
						(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					)
					(gEgo show: normalize: 6)
					(southExit init: 12)
					(gCurRoom drawPic: 33210)
					(proc1111_6)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene394Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 3941 0 0)
					(gCurRoom drawPic: 33220)
				)
				(1
					(ethelFeat dispose:)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(gEgo show: normalize: 6)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(proc1111_6)
					(if (gFeatures contains: ethelFeat)
						(ethelFeat dispose:)
						(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					)
					(gEgo show: normalize: 6)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene395Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(ethelFeat dispose:)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(gEgo hide:)
					(proc1111_7 3950)
					(gCurRoom drawPic: 33220)
				)
				(1
					(doorView init:)
					(gEgo put: 7 hide:) ; invVampBook
					(gGDacSound fade: 0 4 2 1)
					(gCurRoom newRoom: 33000)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gEgo put: 7 hide:) ; invVampBook
					(doorView init:)
					(gGDacSound fade: 0 4 2 1)
					(= global115 0)
					(gCurRoom newRoom: 33000)
				)
			)
		)
	)
)

(instance scene466Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 4660)
					(door dispose:)
					(gCurRoom drawPic: 33220)
					(SetFlag 251)
				)
				(1
					(door init:)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(door init:)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene467Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 4670 -16 -43)
					(door dispose:)
					(gCurRoom drawPic: 33220)
				)
				(1
					(door init:)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(door init:)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene565Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 5650)
					(gEgo hide:)
					(ethelFeat
						init:
						sightAngle: 26505
						setHotspot:
							4 ; Do
							3 ; Move
							0
							8 ; invLibKey
							6 ; invMoney
							7 ; invNail
							9 ; invNewspaper
							10 ; invPoker
							11 ; invHammer
							12 ; invStairKey
							13 ; invVampBook
							14 ; invMatch
							15 ; invTarot
							16 ; invBrooch
							17 ; invPhoto
							18 ; invLensPiece
							19 ; invDrainCln
							20 ; invCrucifix
							22 ; invBeads
							23 ; invSpellBook
							25 ; invXmasOrn
							26 ; invStone
							27 ; invCutter
							28 ; invDogBone
							34 ; invFigurine
						approachVerbs: 0
					)
					(door dispose:)
					(gCurRoom drawPic: 33220)
					(SetFlag 252)
				)
				(1
					(gGame handsOn:)
					(gCurRoom setScript: sWait)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(WalkieTalkie showFrame: 5670 0)
					(ethelFeat
						init:
						sightAngle: 26505
						setHotspot:
							4 ; Do
							3 ; Move
							0
							8 ; invLibKey
							6 ; invMoney
							7 ; invNail
							9 ; invNewspaper
							10 ; invPoker
							11 ; invHammer
							12 ; invStairKey
							13 ; invVampBook
							14 ; invMatch
							15 ; invTarot
							16 ; invBrooch
							17 ; invPhoto
							18 ; invLensPiece
							19 ; invDrainCln
							20 ; invCrucifix
							22 ; invBeads
							23 ; invSpellBook
							25 ; invXmasOrn
							26 ; invStone
							27 ; invCutter
							28 ; invDogBone
							34 ; invFigurine
						approachVerbs: 0
					)
					(door dispose:)
					(gEgo hide:)
					(gCurRoom drawPic: 33220)
					(SetFlag 252)
					(= global115 0)
					(gGame handsOn:)
					(gCurRoom setScript: sWait)
				)
			)
		)
	)
)

(instance scene566Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo hide:)
					(proc1111_7 5660)
					(door dispose:)
					(gCurRoom drawPic: 33220)
					(SetFlag 252)
				)
				(1
					(WalkieTalkie showFrame: 5670 0)
					(ethelFeat
						init:
						sightAngle: 26505
						setHotspot:
							4 ; Do
							3 ; Move
							0
							8 ; invLibKey
							6 ; invMoney
							7 ; invNail
							9 ; invNewspaper
							10 ; invPoker
							11 ; invHammer
							12 ; invStairKey
							13 ; invVampBook
							14 ; invMatch
							15 ; invTarot
							16 ; invBrooch
							17 ; invPhoto
							18 ; invLensPiece
							19 ; invDrainCln
							20 ; invCrucifix
							22 ; invBeads
							23 ; invSpellBook
							25 ; invXmasOrn
							26 ; invStone
							27 ; invCutter
							28 ; invDogBone
							34 ; invFigurine
						approachVerbs: 0
					)
					(gEgo hide:)
					(door dispose:)
					(gCurRoom drawPic: 33220)
					(SetFlag 252)
					(gGame handsOn:)
					(gCurRoom setScript: sWait)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(WalkieTalkie showFrame: 5670 0)
					(ethelFeat
						init:
						sightAngle: 26505
						setHotspot:
							4 ; Do
							3 ; Move
							0
							8 ; invLibKey
							6 ; invMoney
							7 ; invNail
							9 ; invNewspaper
							10 ; invPoker
							11 ; invHammer
							12 ; invStairKey
							13 ; invVampBook
							14 ; invMatch
							15 ; invTarot
							16 ; invBrooch
							17 ; invPhoto
							18 ; invLensPiece
							19 ; invDrainCln
							20 ; invCrucifix
							22 ; invBeads
							23 ; invSpellBook
							25 ; invXmasOrn
							26 ; invStone
							27 ; invCutter
							28 ; invDogBone
							34 ; invFigurine
						approachVerbs: 0
					)
					(door dispose:)
					(gEgo hide:)
					(gCurRoom drawPic: 33220)
					(SetFlag 252)
					(= global115 0)
					(gGame handsOn:)
					(gCurRoom setScript: sWait)
				)
			)
		)
	)
)

(instance scene567Scr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= seconds 15)
				)
				(1
					(gGame handsOff:)
					(ethelFeat dispose:)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(proc1111_7 3921)
				)
				(2
					(gEgo show: normalize: 6)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(ethelFeat dispose:)
					(gEgo show: normalize: 6)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(gCurRoom drawPic: 33210)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene568Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(southExit init: 12)
					(ethelFeat dispose:)
					(proc1111_7 5680)
					(gCurRoom drawPic: 33220)
				)
				(1
					(gEgo show: normalize: 6)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gEgo show: normalize: 6)
					(southExit init: 12)
					(ethelFeat dispose:)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(gCurRoom drawPic: 33210)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene569Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(ethelFeat dispose:)
					(proc1111_7 5690)
					(gCurRoom drawPic: 33220)
				)
				(1
					(gEgo show: normalize: 6)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(southExit init: 12)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(ethelFeat dispose:)
					(= global115 0)
					(gEgo show: normalize: 6)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(southExit init: 12)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance scene570Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo put: 11 hide:) ; invPhoto
					(proc1111_7 5701 0 0 gEgo -1 1)
					(gCurRoom drawPic: 33220)
				)
				(1
					(gGDacSound fade: 0 4 2 1)
					(gCurRoom newRoom: 33300)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gEgo put: 11 hide:) ; invPhoto
					(= global115 0)
					(gGDacSound fade: 0 4 2 1)
					(gCurRoom newRoom: 33300)
				)
			)
		)
	)
)

(instance slamTheDoor of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== gChapter 6)
						(proc1111_7 5670)
					else
						(proc1111_7 3921)
					)
				)
				(1
					(gEgo show: normalize: 6)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(proc1111_6)
					(gEgo show: normalize: 6)
					(gCurRoom drawPic: 33210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance ethelFeat of Feature
	(properties
		nsLeft 20
		nsTop 27
		nsRight 149
		nsBottom 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; invVampBook
				(gGame handsOff:)
				(gCurRoom setScript: scene395Scr)
			)
			(17 ; invPhoto
				(gGame handsOff:)
				(gCurRoom setScript: scene570Scr)
			)
			(4 ; Do
				(cond
					((== gChapter 3)
						(gGame handsOff:)
						(gCurRoom setScript: scene393Scr)
					)
					((== gChapter 6)
						(gGame handsOff:)
						(gCurRoom setScript: scene568Scr)
					)
				)
			)
			(else
				(gGame handsOff:)
				(if (== gChapter 6)
					(gCurRoom setScript: scene569Scr)
				else
					(gCurRoom drawPic: 33220)
					(door init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(southExit init: 12)
					(ethelFeat dispose:)
					(gCurRoom setScript: scene394Scr)
				)
			)
		)
	)
)

(instance doorView of View
	(properties
		x 127
		y 130
		view 33220
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance door of Feature
	(properties
		nsLeft 141
		nsTop 23
		nsRight 191
		nsBottom 103
		x 166
		y 103
	)

	(method (init)
		(super init: &rest)
		(self sightAngle: 26505 setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== gChapter 2)
						(SetFlag 241)
						(gGame handsOff:)
						(if (or (IsFlag 250) (gEgo has: 13)) ; invDrainCln
							(SetFlag 156)
							(gCurRoom setScript: scene301Scr)
							(self dispose:)
						else
							(SetFlag 144)
							(gCurRoom setScript: scene300Scr)
							(self dispose:)
						)
					)
					((== gChapter 3)
						(if (IsFlag 241)
							(gGame handsOff:)
							(gEgo hide:)
							(if (gEgo has: 7) ; invVampBook
								(SetFlag 99)
							)
							(gCurRoom setScript: scene392Scr)
						else
							(SetFlag 241)
							(gGame handsOff:)
							(if (IsFlag 250)
								(SetFlag 156)
								(gCurRoom setScript: scene301Scr)
							else
								(SetFlag 144)
								(gCurRoom setScript: scene300Scr)
							)
						)
					)
					((== gChapter 4)
						(gGame handsOff:)
						(if (IsFlag 251)
							(gCurRoom setScript: scene467Scr)
						else
							(gCurRoom setScript: scene466Scr)
						)
					)
					((== gChapter 6)
						(gGame handsOff:)
						(if (gEgo has: 11) ; invPhoto
							(SetFlag 99)
						)
						(if (IsFlag 252)
							(gCurRoom setScript: scene566Scr)
						else
							(gCurRoom setScript: scene565Scr)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance getMeTheHellOuttaHere of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo view: 7605 cel: 0 setCycle: CT 15 1 self)
				)
				(1
					(gGDacSound setVol: 95)
					(gCurRoom newRoom: 33100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gGDacSound setVol: 95)
					(gCurRoom newRoom: 33100)
				)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft -4
		nsTop 99
		nsRight 123
		approachX 130
		approachY 158
		nextRoom 33100
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (event type:))
			(= global163 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: getMeTheHellOuttaHere)
		)
	)
)

