;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 568)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Teller)
(use forest)
(use Interface)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm568 0
)

(local
	local0
	local1
	local2
)

(instance rm568 of GloryRm
	(properties
		picture 410
		horizon 70
		north 567
		east 572
		south 569
		west 565
		topX 179
		rightY 135
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 127 0 127 74 157 85 157 91 98 107 98 113 109 125 109 132 0 132
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 127 222 127 208 116 151 116 151 106 179 88 242 74 242 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 211 144 319 144 319 189 254 189 211 168
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(if
			(and
				gNight
				(not gCombatMonsterNum)
				(not (IsFlag 35))
				(<= global465 6)
				(> gClock 2100)
			)
			(if gDebugging
				(= global465 (GetNumber {event #? }))
			)
			(RemapColors 2 253 140) ; ByPercent
			(= local1 1)
			(SetFlag 35)
			(SetFlag 338)
			(anna init: setScaler: Scaler 100 40 147 61 setCycle: RandCycle)
			(if (and (<= global465 4) (IsFlag 45))
				(= global465 5)
			)
			(switch global465
				(0
					(heroTeller init: gEgo 568 9 128 6)
					(annaTeller init: anna 568 9 161 6)
					(anna setScript: sMoveToward)
				)
				(1
					(heroTeller init: gEgo 568 9 128 1)
					(annaTeller init: anna 568 9 161 1)
					((ScriptID 50 1) caller: self) ; enterRoomScr
				)
				(2
					(heroTeller init: gEgo 568 9 128 2)
					(annaTeller init: anna 568 9 161 2)
					((ScriptID 50 1) caller: self) ; enterRoomScr
				)
				(3
					(SetFlag 339)
					(= local0 4)
					(heroTeller init: gEgo 568 9 128 3)
					(annaTeller init: anna 568 9 161 3)
					((ScriptID 50 1) caller: self) ; enterRoomScr
				)
				(4
					(heroTeller init: gEgo 568 9 128 4)
					(annaTeller init: anna 568 9 161 4)
					((ScriptID 50 1) caller: self) ; enterRoomScr
				)
				(5
					(= local0 6)
					((ScriptID 50 1) caller: self) ; enterRoomScr
				)
				(6
					(= local0 100)
					(heroTeller init: gEgo 568 9 128 5)
					(annaTeller init: anna 568 9 161 5)
					(nikolaiTeller init: nikolai 568 9 162 5)
					(nikolai
						init:
						setScaler: Scaler 100 40 147 61
						signal: (| (nikolai signal:) $0001)
						setCycle: RandCycle
					)
					((ScriptID 50 1) caller: self) ; enterRoomScr
				)
			)
			(SetFlag 380)
		)
		(if (and local1 (== global465 5))
			(gGlory handsOff:)
		)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 130 77 236 78 216 96 120 115 159 128 127 139 73 116
					yourself:
				)
				60
				((Polygon new:) init: 319 189 177 189 147 174 319 126 yourself:)
				60
				((Polygon new:)
					init: 0 125 36 135 19 143 59 189 0 189
					yourself:
				)
				130
		)
		(atp0 init: setPri: 116)
		(atp1 init: setPri: 159)
		(if gNight
			(atp2 init: setPri: 249)
			(atp3 init: setPri: 249)
			(atp4 init: setPri: 249)
			(atp5 init: setPri: 249)
		)
		(if (and (> global465 10) (not (IsFlag 425)))
			(theHat init:)
		)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)

	(method (dispose)
		(if local1
			(ClearFlag 35)
			(if local0
				(= global465 local0)
			)
		)
		(super dispose: &rest)
	)

	(method (cue)
		(switch global465
			(1
				(gMessager say: 7 6 14) ; "There you are. What happened to you? I thought you were going to show me the way to town."
			)
			(2
				(gMessager say: 7 6 15) ; "I don't understand. Every time I try to follow you, I find myself here again. Why can't I leave this place? Why can't I go home?"
			)
			(3
				(gMessager say: 7 6 16) ; "I remember now. I was walking home. Something started to chase me. I tried to run. Something knocked me over, and everything went black."
			)
			(4
				(gMessager say: 7 6 16) ; "I remember now. I was walking home. Something started to chase me. I tried to run. Something knocked me over, and everything went black."
			)
			(5
				(gCurRoom setScript: sReunited)
			)
			(6
				(gMessager say: 8 6 20) ; "We came back one last time to thank you for reuniting us."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(83 ; dazzleSpell
				(if (gCast contains: anna)
					(gCurRoom setScript: (ScriptID 12) anna 83) ; castAreaScript
				else
					(gCurRoom setScript: (ScriptID 12) 0 83) ; castAreaScript
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance anna of TargActor
	(properties
		noun 7
		x 134
		y 109
		view 569
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed (* 2 global433))
	)

	(method (getHurt)
		(self setScript: sVanish)
	)

	(method (cue)
		(anna getHurt:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self getHurt:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nikolai of TargActor
	(properties
		noun 8
		x 210
		y 109
		view 568
		loop 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed (* 2 global433))
	)

	(method (getHurt)
		(anna getHurt:)
	)
)

(instance theHat of Actor
	(properties
		noun 11
		x 190
		y 112
		view 905
		loop 6
		cel 7
		signal 18433
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(theHat dispose:)
				(gEgo get: 26 1) ; theHat
				(gEgo solvePuzzle: 425 2)
				(gMessager say: noun theVerb 0) ; "It doesn't look as though Nikolai will be needing his hat anymore, so you pick it up and carefully put it away."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doSayMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager
					say:
						(heroTeller sayNoun:)
						(heroTeller verb:)
						(heroTeller iconValue:)
						0
						self
				)
			)
			(1
				(client setScript: sVanish)
			)
		)
	)
)

(instance heroTeller of Teller
	(properties
		loopMenu 0
	)

	(method (sayMessage)
		(ClearFlag 51)
		(switch global465
			(0
				(= local0 1)
				(if (== iconValue 13)
					(self clean:)
					(anna setScript: doSayMessage)
				else
					(super sayMessage: &rest)
				)
			)
			(1
				(= local0 2)
				(if (== iconValue 2)
					(self clean:)
					(anna setScript: doSayMessage)
				else
					(super sayMessage: &rest)
				)
			)
			(2
				(if (== iconValue 4) ; Tell About Ghost
					(gEgo solvePuzzle: 423 6)
					(= local0 3)
					(self clean:)
					(anna setScript: doSayMessage)
				else
					(super sayMessage: &rest)
				)
			)
			(3
				(if (== iconValue 43) ; Say Goodbye
					(= local0 4)
					(self clean:)
					(anna setScript: doSayMessage)
				else
					(super sayMessage: &rest)
				)
			)
			(4
				(if (== iconValue 44) ; Say Goodbye
					(self clean:)
					(anna setScript: doSayMessage)
				else
					(super sayMessage: &rest)
				)
			)
			(6
				(if (== iconValue 42) ; Say Goodbye
					(self clean:)
					(anna setScript: doSayMessage)
				else
					(super sayMessage: &rest)
				)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)

	(method (respond)
		(super respond: &rest)
		(if (== iconValue -999)
			((User curEvent:) claimed: 1)
		)
		(return 1)
	)
)

(instance annaTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 75)) ; annaTalker
	)

	(method (sayMessage)
		(switch global465
			(0
				(= local0 1)
				(if (== iconValue 13) ; Ghost
					(self clean:)
					(anna setScript: sVanish 0 13)
				else
					(super sayMessage: &rest)
				)
			)
			(1
				(= local0 2)
				(if (== iconValue 2) ; Ghost
					(self clean:)
					(anna setScript: sVanish 0 2)
				else
					(super sayMessage: &rest)
				)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4 36 37) ; theRocks, Do, theSword, theThrowdagger
			(anna getHurt:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance nikolaiTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 106 0)) ; oldGhostTalker
	)

	(method (showCases)
		(super showCases: 37 (not (IsFlag 425))) ; Hat
	)

	(method (sayMessage)
		(ClearFlag 51)
		(if (== iconValue 37) ; Hat
			(gEgo solvePuzzle: 425 2)
			(gEgo get: 26 1) ; theHat
		)
		(super sayMessage: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4 36 37) ; theRocks, Do, theSword, theThrowdagger
			(anna getHurt:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance atp0 of ForestView
	(properties
		x 71
		y 6
		view 414
		cel 5
	)
)

(instance atp1 of ForestView
	(properties
		x 210
		y 19
		z -100
		view 414
		cel 6
	)
)

(instance atp2 of ForestView
	(properties
		x 28
		z -189
		view 417
	)
)

(instance atp3 of ForestView
	(properties
		x 18
		y 77
		view 417
		cel 1
	)
)

(instance atp4 of ForestView
	(properties
		x 258
		z -189
		view 418
		loop 1
		cel 1
	)
)

(instance atp5 of ForestView
	(properties
		x 318
		y 20
		view 418
	)
)

(instance sVanish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if register
					(gMessager say: 9 161 register 0 self)
				else
					(= cycles 1)
				)
			)
			(2
				(anna hide:)
				(heroTeller dispose:)
				(annaTeller dispose:)
				(if (gCast contains: nikolai)
					(nikolaiTeller dispose:)
					(gCast delete: nikolai)
					(nikolai dispose:)
				)
				(gMessager say: 7 4 0 0 self) ; "The ghostly apparition vanishes."
			)
			(3
				(anna hide:)
				(if (and (== global465 6) (not (IsFlag 425)))
					(theHat
						init:
						approachVerbs: 4 ; Do
						x: 190
						y: 74
						approachX: 190
						approachY: 117
						setMotion: MoveTo 190 113 self
					)
				else
					(self cue:)
				)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMoveToward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(anna
					setStep: 1 1
					moveSpeed: 12
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
				(= seconds 3)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance sReunited of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(nikolai
					init:
					setScaler: Scaler 100 40 147 61
					signal: (| (nikolai signal:) $0001)
					setCycle: RandCycle
				)
				(= ticks 60)
			)
			(1
				(gMessager say: 8 6 18 0 self) ; "Anna! I found you! Anna..."
			)
			(2
				(nikolai
					signal: (| (nikolai signal:) $0001)
					setPri: (+ (anna priority:) 1)
					setMotion: MoveTo (+ (anna x:) 30) (- (anna y:) 7) self
				)
			)
			(3
				(nikolai setLoop: 2 setCel: 0 setCycle: End self)
				(anna setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4 0)
			(5
				(nikolai hide:)
				(gEgo solvePuzzle: 424 6)
				(anna
					view: 568
					setLoop: 3
					setCel: 0
					x: (+ (anna x:) 7)
					setCycle: End self
				)
			)
			(6
				(gMessager say: 8 6 19 0 self) ; "I love you, Anna. I loved you from the moment you smiled at me, and I will love you for always."
			)
			(7
				(anna setScript: sVanish)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

