;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use rLab)
(use n401)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	rm430 0
)

(instance rm430 of LabRoom
	(properties
		east 400
	)

	(method (init)
		(proc401_3)
		(super init: &rest)
		(theCorpseNorth init: stopUpd:)
		(if (== ((gInventory at: 7) owner:) gCurRoomNum) ; deadMansCoin
			(theGlint init:)
		)
		(gCurRoom setScript: (ScriptID 30 1)) ; walkIn
		((ScriptID 30 0) initCrypt: 4) ; rLab
		((ScriptID 30 6) addToPic:) ; rightDoor
		((ScriptID 30 10) addToPic:) ; rightWing
		((ScriptID 30 8) addToPic:) ; bottomBlock
	)

	(method (notify)
		((ScriptID 30 6) addToPic:) ; rightDoor
		((ScriptID 30 10) addToPic:) ; rightWing
		((ScriptID 30 8) addToPic:) ; bottomBlock
		((ScriptID 30 3) show:) ; theTorch
	)
)

(instance theGlint of Prop
	(properties
		x 132
		y 111
		modNum 400
		view 902
		priority 9
		signal 16400
		cycleSpeed 3
	)

	(method (init)
		(theDeadMansCoin init:)
		(self setScript: glintCoinEyes)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gEgo setScript: getCoins)
			)
			(else
				((ScriptID 30 4) doVerb: theVerb &rest) ; corpseNiche
			)
		)
	)
)

(instance theDeadMansCoin of Prop
	(properties
		x 133
		y 170
		z 58
		noun 13
		modNum 400
		view 431
		loop 6
		priority 8
		signal 16400
		cycleSpeed 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gEgo setScript: getCoins)
			)
			(1 ; Look
				(gMessager say: 13 1 0 0 0 400) ; "Niches in the wall form stone burial beds. Ancient bones lie crumbling on the unyielding rock."
			)
			(else
				((ScriptID 30 4) doVerb: theVerb &rest) ; corpseNiche
			)
		)
	)
)

(instance theCorpseNorth of View
	(properties
		x 132
		y 122
		z 10
		approachX 132
		approachY 112
		view 400
		loop 1
		cel 2
		priority 7
		signal 16400
	)

	(method (init)
		(if (gCast contains: theDeadMansCoin)
			(self noun: 13)
		else
			(self noun: 8)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; deadMansCoin
				(gMessager say: 13 7 0 1 0 400) ; "If the skeleton in the stone bed has not found a use for those coins by now, he or she probably never will."
			)
			(5 ; Do
				(if (gCast contains: theDeadMansCoin)
					(gEgo setScript: getCoins)
				else
					(gCurRoom setScript: (ScriptID 30 11) 0 self) ; checkBody
				)
			)
			(else
				(if (gCast contains: theDeadMansCoin)
					(theDeadMansCoin doVerb: theVerb &rest)
				else
					((ScriptID 30 4) doVerb: theVerb &rest) ; corpseNiche
				)
			)
		)
	)
)

(instance getCoins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 127 149 self)
			)
			(1
				(gEgo
					view: 431
					normal: 0
					setLoop: 5
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 4 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(if (!= ((gInventory at: 7) owner:) gCurRoomNum) ; deadMansCoin
					(gMessager say: 8 5 0 1 self 400) ; "Alexander examines the stone shelf and the ancient bones, but finds nothing except the dust of the grave."
				else
					(gMessager say: 13 5 0 1 self 400) ; "Alexander finds two coins on the skeleton's eyes. He takes the old coins."
				)
			)
			(5
				(gEgo reset: 3)
				(if (== ((gInventory at: 7) owner:) gCurRoomNum) ; deadMansCoin
					(gGame givePoints: 1)
					(gEgo get: 7) ; deadMansCoin
					(theDeadMansCoin dispose:)
					(theGlint dispose:)
				)
				(= seconds 1)
			)
			(6
				(gGame handsOn:)
				(gEgo setHeading: 180)
				(theCorpseNorth noun: 8)
				(self dispose:)
			)
		)
	)
)

(instance glintCoinEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGlint setCycle: Beg self)
			)
			(1
				(theGlint hide:)
				(= seconds 10)
			)
			(2
				(-= state 3)
				(theGlint show:)
				(self cue:)
			)
		)
	)
)

