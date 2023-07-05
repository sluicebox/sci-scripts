;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 406)
(include sci.sh)
(use Main)
(use rLab)
(use n402)
(use n913)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm406 0
)

(local
	local0
	local1 = 10
)

(instance rm406 of LabRoom
	(properties
		south 400
		west 400
	)

	(method (init)
		((ScriptID 30 0) labCoords: 152) ; rLab
		(if (and (== gPrevRoomNum 435) (not (IsFlag 1))) ; trapFloor
			(LoadMany rsVIEW 391 392 393 432)
			(Load rsPALETTE 400)
			(gCurRoom picture: 98)
			(gGlobalSound stop:)
			(super init:)
			((ScriptID 30 0) cue:) ; rLab
			(gEgo
				normal: 0
				view: 433
				x: 165
				y: 95
				ignoreHorizon:
				actions: egoDoTinderBoxCode
				init:
			)
			(UnLoad 128 900)
			(gCurRoom setScript: timerMinotaurKillEgo)
		else
			(gCurRoom picture: 400)
			(proc402_4)
			(super init:)
			((ScriptID 30 3) init:) ; theTorch
			((ScriptID 30 5) addToPic:) ; leftDoor
			((ScriptID 30 9) addToPic:) ; leftWing
			((ScriptID 30 0) initCrypt: 1) ; rLab
			(if (== gPrevRoomNum 435) ; trapFloor
				(gCurRoom setScript: fallDownInLight)
			else
				(gCurRoom setScript: (ScriptID 30 1)) ; walkIn
			)
		)
	)

	(method (notify)
		((ScriptID 30 5) addToPic:) ; leftDoor
		((ScriptID 30 9) addToPic:) ; leftWing
		((ScriptID 30 3) init: show:) ; theTorch
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(20 ; tinderBox
					(if ((ScriptID 30 0) darkRoomLit:) ; rLab
						(gMessager say: 3 20 37 1 0 400) ; "Alexander doesn't need to use the tinder box. The room is light enough already."
						1
					else
						(gCurRoom setScript: lightItUp)
						1
					)
				)
				(1 ; Look
					(if ((ScriptID 30 0) darkRoomLit:) ; rLab
						(super doVerb: theVerb &rest)
						1
					else
						(gMessager say: 2 1 36 1 0 400) ; "Alexander can see nothing in the darkness."
						1
					)
				)
				(2 ; Talk
					(if ((ScriptID 30 0) darkRoomLit:) ; rLab
						(super doVerb: theVerb &rest)
						1
					else
						(gMessager say: 2 2 36 0 0 400) ; "Is...is anybody there?"
						1
					)
				)
				(5 ; Do
					(if ((ScriptID 30 0) darkRoomLit:) ; rLab
						(super doVerb: theVerb &rest)
						1
					else
						(gMessager say: 2 5 36 1 0 400) ; "Alexander can't do anything in the room until he can see."
						1
					)
				)
				(else
					(gMessager say: 3 0 36 1 0 400) ; "Alexander can't use that in the dark."
					1
				)
			)
		)
	)

	(method (scriptCheck &tmp temp0)
		(= temp0 0)
		(if (< local1 100)
			(gMessager say: 3 0 36 1 0 400) ; "Alexander can't use that in the dark."
		else
			(= temp0 1)
		)
		(return temp0)
	)
)

(instance bigEyes of View
	(properties
		view 433
		loop 6
		priority 15
		signal 16400
	)
)

(instance fallDownInLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound4 number: 960 setLoop: 1 play:)
				(gEgo
					setSpeed: 6
					posn: 151 153
					view: 307
					loop: 4
					cel: 0
					normal: 0
					init:
				)
				(= cycles 8)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo posn: 181 157 reset: 5)
				(UnLoad 128 307)
				(= cycles 6)
			)
			(3
				(gMessager say: 1 0 34 0 self 400) ; "They need to get a staircase in here!"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lightItUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gGlobalSound4 number: 932 setLoop: 1 play:)
				(gEgo
					view: 391
					x: (+ (gEgo x:) 7)
					normal: 0
					setLoop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gMessager say: 3 20 36 1 self 400) ; "Alexander takes the candle from his tinder box and uses the flint in the box to light it."
			)
			(2
				(gGame givePoints: 2)
				(proc402_4)
				(gEgo
					view: 3931
					setLoop: 6
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
				(UnLoad 128 391)
			)
			(3
				(gEgo
					view: 3931
					setLoop: 5
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 392
					setLoop: 1
					cycleSpeed: 1
					setCycle: Walk
					setMotion: PolyPath 125 142 self
				)
				0
				(UnLoad 128 3931)
			)
			(5
				(gMessager say: 3 20 36 2 self 400) ; "Aha! So that's why its dark in here! A torch is out."
			)
			(6
				(gGlobalSound2 fade: 0 10 10)
				(gGlobalSound
					number: 400
					setLoop: -1
					setVol: 0
					play:
					fade: 127 10 10
				)
				(gEgo
					view: 432
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End
				)
				(UnLoad 128 392)
				(self setScript: shiftThePalette self)
			)
			(7
				(gMessager say: 3 20 36 3 self 400) ; "Alexander lights the extinguished torch and puts his tinder box away."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shiftThePalette of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palSET_FROM_RESOURCE 400)
				(gCurRoom picture: 400)
				(gCurRoom drawPic: 400 (if global169 15 else 100))
				(Palette palSET_INTENSITY 77 255 local1)
				(= ticks 4)
			)
			(1
				((ScriptID 30 5) addToPic:) ; leftDoor
				((ScriptID 30 9) addToPic:) ; leftWing
				((ScriptID 30 3) init:) ; theTorch
				((ScriptID 30 0) darkRoomLit: 1 notify:) ; rLab
				(= ticks 2)
			)
			(2
				(if (== local1 100)
					(+= state 2)
					(self cue:)
				else
					(= ticks 2)
				)
			)
			(3
				(if (== local1 30)
					(gEgo
						posn: (+ (gEgo x:) 4) (- (gEgo y:) 2)
						reset: 1
					)
					(UnLoad 128 432)
				)
				(Palette palSET_INTENSITY 77 255 local1)
				(= ticks 2)
			)
			(4
				(if (< local1 100)
					(+= local1 5)
					(-= state 2)
				)
				(self cue:)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance timerMinotaurKillEgo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setStep: 3 15 setMotion: MoveTo 165 160 self)
			)
			(1
				(gGlobalSound stop:)
				(gGlobalSound2 number: 405 setLoop: -1 play:)
				(gEgo hide:)
				(ShakeScreen 4 (Random 0 2))
				(= seconds 1)
			)
			(2
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 231 145 82 145 28 183 285 183
							yourself:
						)
				)
				(gEgo show: cycleSpeed: 46 setCycle: RandCycle)
				(= seconds 4)
			)
			(3
				(gEgo
					setLoop: 1
					setStep: 6 10
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(4
				(cond
					((IsFlag 1)
						(gMessager say: 1 0 34 1 self 400) ; "They need to get a staircase in here!"
					)
					((== gPrevRoomNum 400) ; LBRoom
						(self cue:)
					)
					(else
						(gMessager say: 1 0 31 0 self 400) ; "Alexander seems to have fallen to a lower level of the catacombs."
					)
				)
			)
			(5
				(if (and (== gPrevRoomNum 400) (not (IsFlag 1))) ; LBRoom
					(gMessager say: 1 0 33 1 self 400) ; "!!!Do not print this. Comment msg only."
				else
					(self cue:)
				)
			)
			(6
				(gEgo setLoop: 2 cycleSpeed: 24 setCycle: RandCycle)
				(= seconds 4)
			)
			(7
				(gGame handsOn:)
				(if (IsFlag 1)
					(self dispose:)
				else
					(self setScript: lookAround self)
				)
			)
			(8
				(= cycles 4)
			)
			(9
				(gGame handsOff:)
				(gGlobalSound3 number: 401 setLoop: 1 play: self)
			)
			(10
				(gGlobalSound4 number: 433 setLoop: 1 play:)
				(= cycles 10)
			)
			(11
				(gMessager say: 1 0 32 1 self 400) ; "(ANXIOUS) Alexander hears the scrabble of hooves in the dark room."
			)
			(12
				(bigEyes posn: (gEgo x:) (- (gEgo y:) 48) init:)
				(gEgo hide:)
				(= seconds 2)
			)
			(13
				(gMessager say: 1 0 32 2 self 400) ; "He...hello?"
			)
			(14
				(bigEyes dispose:)
				(UnLoad 128 433)
				(gMessager say: 1 0 32 3 self 400) ; "!!!Do sound effect: "GRRROARR!!""
			)
			(15
				(gGlobalSound2 stop:)
				(gGlobalSound number: 406 setLoop: -1 play:)
				(gEgo setLoop: 4 cycleSpeed: 0 cel: 0 show: setCycle: Fwd)
				(= seconds 1)
			)
			(16
				(gEgo posn: (+ (gEgo x:) 30) (gEgo y:))
				(= seconds 1)
			)
			(17
				(gEgo posn: (- (gEgo x:) 30) (gEgo y:))
				(= seconds 1)
			)
			(18
				(gEgo posn: (+ (gEgo x:) 30) (gEgo y:))
				(= seconds 1)
			)
			(19
				(gEgo setLoop: 4 setCycle: End self)
			)
			(20
				(gGlobalSound number: 430 setLoop: 1 play:)
				(gEgo setLoop: 5 cel: 0 cycleSpeed: 8 setCycle: CT 5 1 self)
			)
			(21
				(gGlobalSound number: 431 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(22)
			(23
				(gGlobalSound number: 431 setLoop: 1 play:)
				(gEgo setLoop: 7 cel: 0 cycleSpeed: 30 setCycle: End self)
			)
			(24
				(EgoDead 26) ; "Caught in the dark, Alexander?"
			)
		)
	)
)

(instance lookAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gHowFast 0)
					(= seconds 8)
				else
					(= seconds (Random 2 4))
				)
			)
			(1
				(gEgo setLoop: 3 cel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(2
				(gEgo setLoop: 2 cel: 0 cycleSpeed: 48 setCycle: Fwd)
				(if (< local0 4)
					(++ local0)
					(-= state 3)
				)
				(self cue:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance egoDoTinderBoxCode of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(switch theVerb
			(20 ; tinderBox
				(if ((ScriptID 30 0) darkRoomLit:) ; rLab
					(gMessager say: 3 20 37 1 0 400) ; "Alexander doesn't need to use the tinder box. The room is light enough already."
				else
					(gCurRoom setScript: lightItUp)
				)
			)
			(else
				(if (== (gKq6ApproachCode doit: theVerb) -32768)
					(gMessager say: 3 0 36 1 0 400) ; "Alexander can't use that in the dark."
				else
					(= temp0 0)
				)
			)
		)
		(return temp0)
	)
)

