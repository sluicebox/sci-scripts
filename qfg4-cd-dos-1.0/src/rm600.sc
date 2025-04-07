;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use Interface)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance rm600 of GloryRm
	(properties
		noun 1
		picture 600
		north 610
		south 552
		bottomX 150
	)

	(method (init)
		(gGlory handsOff:)
		(gLongSong doSongs: stop:)
		(if gDebugging
			(cond
				((== (= local0 (GetNumber {Event #?})) 1)
					(= gPrevRoomNum 630)
				)
				((OneOf local0 2 3 4 5 6 7 8 9 10)
					(if (== local0 7)
						(SetFlag 122)
					)
					(= gPrevRoomNum 552)
				)
				((== local0 11)
					(= gPrevRoomNum 670)
				)
			)
		else
			(= local0
				(cond
					(
						(and
							(== gPrevRoomNum 552)
							(< 4 gTime 6)
							(IsFlag 124)
							(IsFlag 395)
						)
						12
					)
					((== gPrevRoomNum 670) 11)
					(
						(and
							(OneOf gPrevRoomNum 552 670)
							(IsFlag 110)
							(or (gEgo has: 52) (IsFlag 323)) ; theBoneRit
							(or (gEgo has: 53) (IsFlag 324)) ; theBloodRit
							(or (gEgo has: 55) (IsFlag 325)) ; theSenseRit
							(or (gEgo has: 56) (IsFlag 326)) ; theHeartRit
							(or (gEgo has: 54) (IsFlag 327)) ; theBreathRit
						)
						10
					)
					((== gPrevRoomNum 610) 1)
					(
						(and
							(== gPrevRoomNum 552)
							(<= 4 gTime 6)
							(< gPrevKatrinaDayNumber (- gDay 2))
							(IsFlag 124)
							(not (IsFlag 395))
							(not (IsFlag 115))
						)
						9
					)
					(
						(and
							(== gPrevRoomNum 552)
							gNight
							(<= 4 gTime 6)
							(< gPrevKatrinaDayNumber gDay)
							(IsFlag 82)
							(not (IsFlag 124))
							(not (IsFlag 115))
						)
						8
					)
					(
						(and
							(== gPrevRoomNum 552)
							(IsFlag 122)
							(not gNight)
							(not (IsFlag 123))
						)
						7
					)
					((and (not gNight) (< global425 gDay) (IsFlag 121)) 6)
					(
						(and
							(== global425 gDay)
							(IsFlag 121)
							(not gNight)
						)
						5
					)
					((and (not (IsFlag 120)) (not gNight)) 2)
					(
						(and
							(< global425 gDay)
							(not (IsFlag 121))
							(not gNight)
						)
						4
					)
					(
						(and
							(IsFlag 120)
							(== global425 gDay)
							(not gNight)
						)
						3
					)
					(else 0)
				)
			)
		)
		(if (or (not (== local0 11)) (not (== local0 10)))
			(gEgo init: normalize: setScaler: Scaler 130 45 189 109)
		)
		(if (or (OneOf gPrevRoomNum 810 610 630) (== local0 10)) ; combat
			(aGate posn: -30 105 setPri: 163 init:)
		else
			(aGate init: approachVerbs: 4) ; Do
			(cond
				((== local0 10)
					(aGate posn: -30 105)
				)
				((not (IsFlag 122))
					(if gNight
						(gateTeller init: aGate 600 14 125 15)
					else
						(gateTeller init: aGate 600 14 125 13)
					)
				)
			)
		)
		(if (or (OneOf gPrevRoomNum 670 810 610 630) (== local0 10)) ; combat
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 275 163 255 151 225 151 217 159 200 159 193 166 122 166 107 151 116 134 193 118 215 109 226 114 229 110 227 107 225 110 214 105 159 118 140 104 95 114 48 134 26 155 78 144 80 164 61 174 100 189 -300 189 -300 0 619 0 619 189 236 189
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 59 169 62 175 99 189 0 189 0 0 619 0 619 189 236 189 275 163 255 151 223 151 216 158 201 159 194 166 122 166 115 160
						yourself:
					)
			)
		)
		(switch gPrevRoomNum
			(670
				(= gNight 1)
				(= gTime 6)
				((ScriptID 7 4) init: 24 0) ; fixTime
				(gCurRoom setScript: sEvent11)
			)
			(810 ; combat
				(cond
					((== gCombatResult 1)
						(sndNecRoar play:)
						(gEgo
							view: 43
							setLoop: 2 1
							setCel: 0
							posn: 100 147
							setCycle: End
						)
						(pNec2
							view: 872
							posn: (- (gEgo x:) 10) (- (gEgo y:) 12)
							setCel: 0
							init:
							ignoreActors: 1
						)
						(if (IsFlag 119)
							(pNec1 view: 872 posn: 42 128 setCel: 5 init:)
							(gCurRoom setScript: sOneDead)
						else
							(pNec1
								view: 872
								setLoop: 1 1
								posn: (+ (gEgo x:) 10) (+ (gEgo y:) 12)
								setCel: 0
								init:
								ignoreActors: 1
							)
							(gCurRoom setScript: sDead)
						)
					)
					((not (IsFlag 119))
						(sndNecRoar play:)
						(SetFlag 119)
						(gEgo posn: 107 152)
						(pNec1
							view: 872
							setCel: 0
							posn: 42 128
							init:
							setCycle: End
						)
						(pNec2 init:)
						(gCurRoom setScript: sGoToCombat)
					)
					(else
						(SetFlag 102)
						(SetFlag 122)
						(gEgo posn: 107 152)
						(pNec1
							view: 872
							setLoop: 0 1
							setCel: 5
							posn: 42 128
							init:
						)
						(pNec2
							view: 872
							setCel: 0
							setLoop: 0 1
							posn: 246 158
							init:
							setCycle: End
						)
						(gGlory handsOn:)
					)
				)
			)
			(610
				(gEgo x: 225 y: 108 setScript: sFromCastle)
			)
			(630
				(gEgo x: 225 y: 108 setScript: sFromCastle)
			)
			(else
				(gEgo x: 100 y: 250 setScript: sFromSouth)
				(switch local0
					(2
						(gCurRoom setScript: sEvent2)
						(= local2 1)
					)
					(3
						(gCurRoom setScript: sEvent3)
						(= local2 1)
					)
					(4
						(gCurRoom setScript: sEvent4)
						(= local2 2)
					)
					(5
						(gCurRoom setScript: sEvent5)
						(= local2 2)
					)
					(6
						(gCurRoom setScript: sEvent6)
						(= local2 3)
					)
					(7
						(gCurRoom setScript: sEvent7)
					)
					(8
						(aKatrina init: approachVerbs: 4) ; Do
						(katrinaTeller init: aKatrina 600 14 127 21)
						(heroTeller init: gEgo 600 14 128 21)
						(= local7 1)
						(gCurRoom setScript: sEvent8)
					)
					(9
						(aKatrina init: approachVerbs: 4) ; Do
						(katrinaTeller init: aKatrina 600 14 127 22)
						(heroTeller init: gEgo 600 14 128 22)
						(= local7 1)
						(SetFlag 395)
						(gCurRoom setScript: sEvent9)
					)
					(10
						(fStop init:)
						(gCurRoom setScript: sEvent10)
					)
				)
			)
		)
		(if (and (!= global425 gDay) (not (== gPrevRoomNum 810))) ; combat
			(ClearFlag 119)
		)
		(if
			(and
				(not (IsFlag 119))
				(not (OneOf local0 2 3 4 5 6 7 10))
				(or (== gPrevRoomNum 552) (== gPrevRoomNum 670))
				gNight
			)
			(pNec1 init:)
			(pNec2 init: setScript: sRandomRoars)
		)
		(cond
			((OneOf local0 8 9)
				(gLongSong number: 110 setLoop: -1 play:)
			)
			(gNight
				(gLongSong number: 557 loop: -1 play:)
			)
			(else
				(gLongSong number: 558 loop: -1 play:)
			)
		)
		(if (not (== local0 10))
			(specialEFtr
				nsLeft: 0
				nsTop: 187
				nsBottom: 189
				nsRight: 248
				approachX: 150
				approachY: 189
				init:
			)
		)
		(if
			(and
				(OneOf local0 2 3 4 5 6 7)
				(not (OneOf gPrevRoomNum 610 630))
			)
			(heroTeller
				init:
					gEgo
					600
					14
					128
					(if (IsFlag 122)
						20
					else
						(switch local2
							(1 17)
							(2 18)
							(3 19)
						)
					)
			)
			(= local1 1)
			(gateKeeper init: setScript: sKeeperIncidental approachVerbs: 4 2) ; Do, Talk
			(keeperTeller
				init:
					gateKeeper
					600
					14
					153
					(if (IsFlag 122)
						20
					else
						(switch local2
							(1 17)
							(2 18)
							(3 19)
						)
					)
			)
		else
			(fTowerWindow init: approachVerbs: 4) ; Do
		)
		(super init: &rest)
		(fNextRoom init: approachVerbs: 4) ; Do
		(fCastle init: approachVerbs: 4) ; Do
		(fRoad init: approachVerbs: 4) ; Do
		(fRoad2 init: approachVerbs: 4) ; Do
		(fTree init: approachVerbs: 4) ; Do
		(fParapet init: approachVerbs: 4) ; Do
		(fTower init: approachVerbs: 4) ; Do
		(fArchWay init: approachVerbs: 4) ; Do
		(if (and (IsFlag 380) (!= gPrevRoomNum 810)) ; combat
			(gGlory save: 1)
		)
	)

	(method (leaveRoom &tmp temp0)
		(if local1
			(switch local0
				(2
					(gMessager say: 2 6 30) ; "Goodbye, young man. 'May the fireplace be warm and the drink cold at your journey's end.'"
				)
				(3
					(proc0_17 2 6 42 0 600)
				)
				(4
					(gMessager say: 2 6 31) ; "Good luck, and 'May your feet move faster than the thing that chases you!'"
				)
				(5
					(proc0_17 2 6 42 0 600)
				)
				(6
					(proc0_17 2 6 42 0 600)
				)
				(8
					(switch (= temp0 (Random 1 5))
						(1
							(gMessager say: 16 6 42 1) ; MISSING MESSAGE
						)
						(2
							(gMessager say: 16 6 42 2) ; MISSING MESSAGE
						)
						(3
							(gMessager say: 16 6 42 3) ; MISSING MESSAGE
						)
						(4
							(gMessager say: 16 6 42 4) ; MISSING MESSAGE
						)
						(5
							(gMessager say: 16 6 42 5) ; MISSING MESSAGE
						)
					)
					(= gPrevKatrinaDayNumber gDay)
				)
				(9
					(switch (= temp0 (Random 1 5))
						(1
							(gMessager say: 16 6 42 1) ; MISSING MESSAGE
						)
						(2
							(gMessager say: 16 6 42 2) ; MISSING MESSAGE
						)
						(3
							(gMessager say: 16 6 42 3) ; MISSING MESSAGE
						)
						(4
							(gMessager say: 16 6 42 4) ; MISSING MESSAGE
						)
						(5
							(gMessager say: 16 6 42 5) ; MISSING MESSAGE
						)
					)
					(= gPrevKatrinaDayNumber gDay)
				)
			)
		)
		(ClearFlag 102)
		(= global425 gDay)
		(super leaveRoom:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== (gCurRoom script:) (ScriptID 31 1)) (>= (gEgo z:) 124)) ; sLevitate
			(gCurRoom setScript: sLevitating)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; levitateSpell
				(gEgo trySkill: 29) ; levitateSpell
				(cond
					(gNight
						((ScriptID 31 0) init: 108 166 125 0 3) ; leviCode
					)
					(local1
						(gMessager say: 2 6 8) ; "Please do not try to force the gate. It is my duty to keep strangers away from the castle."
					)
					(else
						(gMessager say: 12 6 7) ; "Your spell dissipates as if blocked by magic. It does not seem to have had any effect."
					)
				)
			)
			(1 ; Look
				(cond
					((and (!= local0 10) (not gNight))
						(gMessager say: 1 1 3) ; "A heavy gate blocks the way to the winding road. Far in the distance you can see a majestic castle."
						(return 1)
					)
					((and (!= local0 10) gNight)
						(gMessager say: 1 1 2) ; "A heavy gate guarded by two Necrotaurs blocks the way to the winding road. Far in the distance you can see a dark, ominous castle."
						(return 1)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(83 ; dazzleSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(if local7
					(gMessager say: 12 6 28 0) ; "Something about being with Katrina makes all thought of magic swirl around in your head. You don't seem to be able to cast any of your spells."
				else
					(gEgo trySkill: 12) ; magic
					(= local5 3)
					(gCurRoom setScript: sThrowIt)
				)
			)
			(86 ; flameDartSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(if local7
					(gMessager say: 12 6 28 0) ; "Something about being with Katrina makes all thought of magic swirl around in your head. You don't seem to be able to cast any of your spells."
				else
					(gEgo trySkill: 12) ; magic
					(= local5 5)
					(gCurRoom setScript: sThrowIt)
				)
			)
			(88 ; forceBoltSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(if local7
					(gMessager say: 12 6 28 0) ; "Something about being with Katrina makes all thought of magic swirl around in your head. You don't seem to be able to cast any of your spells."
				else
					(gEgo trySkill: 12) ; magic
					(= local5 6)
					(gCurRoom setScript: sThrowIt)
				)
			)
			(91 ; jugglingLightsSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(if local7
					(gMessager say: 12 6 28 0) ; "Something about being with Katrina makes all thought of magic swirl around in your head. You don't seem to be able to cast any of your spells."
				else
					(gEgo trySkill: 12) ; magic
					(= local5 7)
					(gCurRoom setScript: sThrowIt)
				)
			)
			(93 ; lightningBallSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(if local7
					(gMessager say: 12 6 28 0) ; "Something about being with Katrina makes all thought of magic swirl around in your head. You don't seem to be able to cast any of your spells."
				else
					(gEgo trySkill: 12) ; magic
					(= local5 9)
					(gCurRoom setScript: sThrowIt)
				)
			)
			(81 ; detectMagicSpell
				(gEgo trySkill: 21) ; detectSpell
				(gMessager say: 0 81 0 0) ; "The gate seems to be magically enchanted."
			)
			(21 ; theRocks
				(self setScript: (ScriptID 32) 0 21) ; project
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gLongSong fade: 0)
		(zappedSound dispose:)
		(super dispose:)
	)
)

(instance sRandomRoars of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self cue:)
			)
			(1
				(= seconds (Random 1 20))
			)
			(2
				(sndNecRoar play: self)
			)
			(3
				(sndNecRoar stop:)
				(self changeState: 0)
			)
		)
	)
)

(instance sLevitating of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setScaler: Scaler 85 80 110 0 posn: 104 38 setCel: 5)
				(= ticks 30)
			)
			(1
				(gEgo setPri: 86 setCycle: 0 setMotion: JumpTo 88 148 self)
			)
			(2
				(if (or (== local0 10) (IsFlag 119))
					(gEgo
						normalize:
						setLoop: 7
						posn: 88 143
						setScaler: Scaler 130 45 189 109
					)
					(gGlory handsOn:)
					(self dispose:)
				else
					(gEgo
						view: 43
						setLoop: 2 1
						setCel: 0
						posn: 98 145
						setCycle: 0
					)
					(pNec1
						view: 870
						setLoop: 0 1
						setCel: 0
						setCycle: Walk
						setMotion: MoveTo 53 145 self
					)
				)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(EgoDead 10 600 0 0 912) ; "You climbed the gate just fine. You climbed down just fine too. The Necrotaurs killed you quite nicely before you could reach the ground. Isn't that nice?"
			)
		)
	)
)

(instance sStop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= ticks 12)
			)
			(1
				(gMessager say: 12 6 25 0 self) ; "You find that you are unable to walk south from here. You are compelled to return to the castle."
			)
			(2
				(gEgo setMotion: PolyPath 121 181 self)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKatrinaWalksAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 5)
			)
			(1
				(katrinaTeller dispose:)
				(if (== local0 8)
					(gMessager say: 16 6 36 1 self) ; "I've got to be off now. Please meet me again, say, three nights hence? I'll be waiting to see you here."
				else
					(gMessager say: 16 6 38 1 self) ; "Please, work on your skills before we next meet. Mordavia is a very dangerous place. I do need your help, but I don't want anything harmful to happen to you. Farewell."
				)
			)
			(2
				(aKatrina
					setLoop: 1 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo -20 180 self
				)
			)
			(3
				(aKatrina hide: dispose:)
				(heroTeller dispose:)
				(if (== local0 8)
					(gMessager say: 12 6 26 1 self) ; "Katrina walks off into the forest to the west and is quickly gone from sight."
				else
					(gMessager say: 12 6 40 1 self) ; "Katrina seems to walk off into the mist. Odd, you've never noticed much fog around this area of the forest."
				)
			)
			(4
				(= gPrevKatrinaDayNumber gDay)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch local5
					(1
						(if (== (gEgo has: 5) 1) ; theThrowdagger
							(gMessager say: 12 6 116) ; "You are down to your last dagger. You'd better hold on to it."
						else
							(self setScript: (ScriptID 32) self 37) ; project
						)
					)
					(2
						(self setScript: (ScriptID 32) self 21) ; project
					)
					(5
						(self setScript: (ScriptID 32) self 86) ; project
					)
					(6
						(self setScript: (ScriptID 32) self 88) ; project
					)
					(7
						(self setScript: (ScriptID 62) self) ; castJuggle
					)
					(8
						(self setScript: (ScriptID 32) self 93) ; project
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gEgo normalize:)
				(= seconds 2)
			)
			(2
				(if (OneOf local5 1 2)
					(gMessager say: 12 6 6 0 self) ; "Your missile vanishes as if by magic. (In fact, it probably IS by magic.)"
				else
					(gMessager say: 12 6 7 0 self) ; "Your spell dissipates as if blocked by magic. It does not seem to have had any effect."
				)
			)
			(3
				(= local5 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbTheGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 108 166 self)
			)
			(1
				(Face gEgo 123 168 self)
			)
			(2
				(gEgo
					view: 7
					setLoop: 3 1
					setCel: 0
					posn: 109 163
					setCycle: Fwd
					ignoreActors: 1
					setPri: 174
					setScaler: Scaler 114 77 166 30
					setMotion: MoveTo 108 91 self
				)
			)
			(3
				(gEgo setLoop: 4 1 setCel: 0 posn: 106 38 setCycle: End self)
			)
			(4
				(gEgo
					view: 58
					setLoop: 0 1
					setCel: 0
					posn: 99 39
					setPri: 53
					setCycle: CT 1 1 self
				)
			)
			(5
				(gEgo setMotion: JumpTo 93 140 self)
			)
			(6
				(gEgo setCycle: CT 5 1 self)
			)
			(7
				(gEgo setLoop: 2 1 setCel: 0 setCycle: End self)
			)
			(8
				(if (or (== local0 10) (IsFlag 119))
					(gEgo normalize: setPri: 53)
					(gGlory handsOn:)
					(self dispose:)
				else
					(gEgo view: 43 setLoop: 2 1 setCel: 0 posn: 95 143)
					(pNec1
						view: 870
						setLoop: 0 1
						setCel: 0
						setPri: 64
						setCycle: Walk
						setMotion: MoveTo 53 145 self
					)
				)
			)
			(9
				(gEgo setCycle: End self)
			)
			(10
				(EgoDead 10 600 0 0 912) ; "You climbed the gate just fine. You climbed down just fine too. The Necrotaurs killed you quite nicely before you could reach the ground. Isn't that nice?"
			)
		)
	)
)

(instance sSlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 114 167 self)
			)
			(1
				(Face gEgo 123 168 self)
			)
			(2
				(gEgo
					view: 38
					setLoop: 1 1
					setCel: 0
					posn: 113 169
					setCycle: End self
				)
			)
			(3
				(sndSwish play:)
				(gEgo setLoop: 5 1 setCel: 0 x: 115 setCycle: Osc 4 self)
			)
			(4
				(gEgo setCel: 8 setCycle: Beg self)
			)
			(5
				(gEgo setLoop: 1 1 setCel: 10 x: 113 setCycle: Beg self)
			)
			(6
				(gEgo posn: 114 167 normalize:)
				(gMessager say: 12 6 8 0 self) ; "You wouldn't accomplish anything but dulling your blade."
			)
			(7
				(if local1
					(gMessager say: 2 6 8 0 self) ; "Please do not try to force the gate. It is my duty to keep strangers away from the castle."
				else
					(self cue:)
				)
			)
			(8
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sZapTheGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 80 167 self)
			)
			(1
				(gEgo view: 31 setLoop: 1 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(zappedSound play:)
				(aZap init: setCycle: CT 1 1 self)
			)
			(3
				(aZap setCycle: CT 0 -1 self)
			)
			(4
				(zappedSound stop:)
				(aZap dispose:)
				(if (< (-= [gEgoStats 17] 50) 0) ; health
					(EgoDead 9 600 0 0 912) ; "Your whole life flashes before your eyes (along with lots of other bright lights) as the gate spell zaps you into oblivion. Touchy, these homeowners."
				else
					(gEgo setCycle: CT 0 -1 self)
				)
			)
			(5
				(gEgo normalize:)
				(gMessager say: 11 4 9 0 self) ; "Yow! A powerful shock goes through you as you touch the gate. The castle inhabitants seem to have set up a burglar-deterrent after the previous break-in."
			)
			(6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOneDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 5)
			)
			(1
				(EgoDead 12 600 0 0 912) ; "You heroically slaughtered one of the guardian Necrotaurs. Unfortunately, the second one unheroically made mincemeat of you. You'll need to work up to this encounter in your next life."
			)
		)
	)
)

(instance sDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 5)
			)
			(1
				(EgoDead 11 600 0 0 912) ; "The Necrotaurs are having you for a midnight snack. You might want to leave frontal assaults for later, or at least prepare for combat better."
			)
		)
	)
)

(instance sCheckNecs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath local3 local4 self)
			)
			(1
				(gEgo
					view: 4
					setLoop: (if (< (gEgo x:) 50) 2 else 0) 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 3 4 14 0 self) ; "There is nothing of value on the Necrotaur's body."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoToCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 4)
			)
			(1
				(= gCombatMonsterNum 870) ; nectar
				(= global156 350)
				(pNec2
					view: 870
					setLoop: 1 1
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
				(= cycles 24)
			)
			(2
				(SetFlag 378)
				(gCurRoom newRoom: 810) ; combat
			)
		)
	)
)

(instance sForceGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 108 157 self)
			)
			(1
				(sndMetalGate play:)
				(aGate setLoop: 0 1 setCel: 0 setMotion: MoveTo -30 103 self)
				(= cycles 5)
			)
			(2
				(= gCombatMonsterNum 870) ; nectar
				(= global156 350)
				(sndMetalGate stop:)
				(gEgo setMotion: MoveTo 107 155 self)
			)
			(3)
			(4
				(SetFlag 102)
				(SetFlag 378)
				(gCurRoom newRoom: 810) ; combat
			)
		)
	)
)

(instance sFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local0 10)
					(gEgo setScaler: Scaler 130 45 189 109)
				else
					(gEgo setScaler: Scaler 120 105 189 156)
				)
				(gEgo setMotion: PolyPath 121 181 self)
			)
			(1
				(if gNight
					(if (== gHeroType 3) ; Paladin
						(gMessager say: 12 6 118) ; "Death waits beyond those gates (at least for those not tough enough for the challenge). It comes in the form of two slavering Necrotaurs."
					)
					(sndLightning play:)
				)
				(if (not (gCurRoom script:))
					(gGlory handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sFromCastle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 101 126 self)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTo610 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setLoop: 6 1 setMotion: MoveTo 227 116 self)
			)
			(1
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sEvent2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= global425 gDay)
				(SetFlag 120)
				(= seconds 5)
			)
			(1
				(gMessager say: 12 6 24 0 self) ; "A heavy gate blocks the way to the winding road. Far in the distance you can see a majestic castle."
			)
			(2
				(if local1
					(gMessager say: 2 6 29) ; "Welcome to Mordavia. It's nice to have some fresh blood around here. We so seldom see strangers."
				)
				(self cue:)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= global425 gDay)
				(= seconds 5)
			)
			(1
				(if local1
					(proc0_17 2 6 41 self 600)
				else
					(self cue:)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent4 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 121)
				(= global425 gDay)
				(= seconds 5)
			)
			(1
				(if local1
					(gMessager say: 2 6 32) ; "Welcome again to the gates of the Castle Borgov. I hope that you have been enjoying your visit to Mordavia."
				)
				(self cue:)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 5)
			)
			(1
				(if local1
					(proc0_17 2 6 41 self 600)
				else
					(self cue:)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent6 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 5)
			)
			(1
				(if local1
					(proc0_17 2 6 41 self 600)
				else
					(self cue:)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 123)
				(= seconds 5)
			)
			(1
				(if local1
					(gMessager say: 2 6 33) ; "The strangest thing happened the other night. Someone broke open the gate and killed the Necrotaurs. The Master came by later and was furious that her guards were dead."
				)
				(self cue:)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 124)
				(= seconds 5)
			)
			(1
				(gMessager say: 16 6 35 0 self) ; "Oh, you did come! I was beginning to think I'd never get to see you again. It is so dangerous to wander in Mordavia. I was quite frightened for you."
				(self cue:)
			)
			(2
				(Face gEgo 61 174 self)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 399)
				(SetFlag 125)
				(= seconds 5)
			)
			(1
				(gMessager say: 16 6 37 0 self) ; "Did you get my message? I hoped you would come to see me here again. I wanted to ask a favor of you."
			)
			(2
				(Face gEgo 61 174 self)
			)
			(3
				(if (> [gEgoStats 17] (gEgo maxHealth:)) ; health
					(gEgo get: 3) ; theHeals
					(gMessager say: 16 6 39 1 self) ; "You're hurt again! Please, you need to take better care of yourself. There are many things in Mordavia that are attracted to the scent of blood. Please take this potion and use it quickly."
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

(instance sEvent10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 101)
				(= seconds 3)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent11 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo
					view: 161
					setLoop: 2
					setScaler: Scaler 130 45 189 109
					posn: 111 173
				)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(2
				(gEgo setLoop: 1)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(3
				(gEgo setLoop: 0)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKeeperIncidental of Script
	(properties)

	(method (doit)
		(if (gEgo mover:)
			(cond
				((< (gEgo x:) 140)
					(gateKeeper setCel: 3)
				)
				((< (gEgo x:) 192)
					(gateKeeper setCel: 0)
				)
				(else
					(gateKeeper setCel: 1)
				)
			)
			(= state 0)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(= seconds (Random 2 8))
			)
			(2
				(gateKeeper
					setLoop: 1 1
					setCel:
						(if (== (gateKeeper cel:) 3)
							0
						else
							(+ (gateKeeper cel:) 1)
						)
				)
				(= cycles 1)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance aKatrina of Actor
	(properties
		noun 16
		approachX 61
		approachY 174
		x 20
		y 182
		view 602
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 37) ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 12 6 116) ; "You are down to your last dagger. You'd better hold on to it."
				else
					(gMessager say: 12 6 27) ; "You don't have any reason to attack Katrina; in fact, you feel amazingly relaxed and comfortable around her."
				)
			)
			((OneOf theVerb 36 21) ; theSword, theRocks
				(gMessager say: 12 6 27) ; "You don't have any reason to attack Katrina; in fact, you feel amazingly relaxed and comfortable around her."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aGate of Actor
	(properties
		noun 11
		approachX 123
		approachY 168
		x 27
		y 97
		view 600
	)

	(method (doVerb theVerb)
		(= global441 ((User curEvent:) x:))
		(= global442 ((User curEvent:) y:))
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 122)
						(gMessager say: 11 1 5) ; "The gate is standing open, its lock broken."
					)
					((and (!= local0 10) gNight)
						(gMessager say: 11 1 2) ; "The heavy gate blocks access to the castle road. Fortunately, it also blocks the path of the two slavering Necrotaurs on the other side. They look hungry to see you."
					)
					((!= local0 10)
						(gMessager say: 11 1 3) ; "This heavy gate blocks access to the castle road. (The gate makes you wait.)"
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(37 ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 12 6 116) ; "You are down to your last dagger. You'd better hold on to it."
				else
					(gEgo trySkill: 10) ; throwing
					(gEgo use: 5 1) ; theThrowdagger
					(= local5 1)
					(gCurRoom setScript: sThrowIt)
				)
			)
			(21 ; theRocks
				(gEgo trySkill: 10) ; throwing
				(gEgo use: 6 1) ; theRocks
				(= local5 2)
				(gCurRoom setScript: sThrowIt)
			)
			(82 ; triggerSpell
				(if local7
					(gMessager say: 12 6 28) ; "Something about being with Katrina makes all thought of magic swirl around in your head. You don't seem to be able to cast any of your spells."
				else
					(= global441 ((User curEvent:) x:))
					(= global442 ((User curEvent:) y:))
					(= local5 9)
					(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
				)
			)
			(-82 ; triggerSpell (part 2)
				(gEgo trySkill: 22) ; triggerSpell
				(gCurRoom setScript: sThrowIt)
			)
			(4 ; Do
				(gCurRoom setScript: sZapTheGate)
			)
			(36 ; theSword
				(gCurRoom setScript: sSlash)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gEgo trySkill: 20) ; openSpell
				(gCurRoom setScript: (ScriptID 13) 0 aGate) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gGlory handsOn:)
				(gCurRoom setScript: 0)
				(gEgo trySkill: 20) ; openSpell
				(gMessager say: 12 6 7) ; "Your spell dissipates as if blocked by magic. It does not seem to have had any effect."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pNec1 of Actor
	(properties
		noun 3
		x 33
		y 133
		fixPriority 1
		view 872
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setScaler: Scaler 80 72 144 115)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (IsFlag 119)) ; Look
			(gMessager say: 3 1 0) ; "The recently-deceased gate guardians are Necrotaurs. They don't look much better in death."
			(return 1)
		else
			(gMessager say: 3 1 117) ; "The heavy gate blocks access to the castle road. Fortunately, it also blocks the path of the two slavering Necrotaurs on the other side. They look hungry to see you."
			(return 1)
		)
		(return
			(if (and (== theVerb 4) (IsFlag 119)) ; Do
				(= local3 53)
				(= local4 136)
				(gCurRoom setScript: sCheckNecs)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pNec2 of Actor
	(properties
		noun 3
		x 110
		y 150
		view 872
		loop 1
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 17 ignoreActors: 1 setScaler: Scaler 80 76 153 122)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (IsFlag 119)) ; Look
			(gMessager say: 3 1 0) ; "The recently-deceased gate guardians are Necrotaurs. They don't look much better in death."
			(return 1)
		else
			(gMessager say: 3 1 117) ; "The heavy gate blocks access to the castle road. Fortunately, it also blocks the path of the two slavering Necrotaurs on the other side. They look hungry to see you."
			(return 1)
		)
		(return
			(if (and (== theVerb 4) (IsFlag 119)) ; Do
				(= local3 252)
				(= local4 163)
				(gCurRoom setScript: sCheckNecs)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aZap of Actor
	(properties
		x 79
		y 166
		view 31
		loop 2
		signal 16385
	)
)

(instance gateKeeper of Prop
	(properties
		noun 2
		x 155
		y 108
		priority 141
		fixPriority 1
		view 600
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== theVerb 59) ; theFlowers
			(gEgo use: 40) ; theFlowers
		)
		(super doVerb: theVerb &rest)
	)
)

(instance fNextRoom of Feature
	(properties
		nsLeft 225
		nsTop 105
		nsRight 233
		nsBottom 117
		sightAngle 180
		x 225
		y 107
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 225 105 233 105 233 117 225 109
						yourself:
					)
					0
					3
					6
					sTo610
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fStop of Feature
	(properties
		nsLeft 225
		nsTop 105
		nsRight 233
		nsBottom 117
		sightAngle 180
		x 225
		y 107
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 85 184 264 184 265 189 63 189 67 184
						yourself:
					)
					2
					4
					5
					sStop
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fCastle of Feature
	(properties
		noun 4
		nsLeft 232
		nsTop 10
		nsRight 265
		nsBottom 54
		sightAngle 180
		x 248
		y 32
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 4 1 2) ; "A dark, ominous castle looms upon the tall, craggy mountain."
			else
				(gMessager say: 4 1 3) ; "Far in the distance you can see a grim but majestic castle."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fRoad of Feature
	(properties
		noun 5
		nsLeft 229
		nsTop 54
		nsRight 287
		nsBottom 115
		sightAngle 180
		x 258
		y 84
	)
)

(instance fRoad2 of Feature
	(properties
		noun 5
		nsLeft 185
		nsTop 95
		nsRight 236
		nsBottom 110
		sightAngle 180
		x 210
		y 102
	)
)

(instance fTree of Feature
	(properties
		noun 6
		nsLeft 265
		nsTop 1
		nsRight 319
		nsBottom 150
		sightAngle 180
		approachX 262
		approachY 156
		x 1
		y 75
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 6 1 2) ; "The oak tree seems to beckon you towards it, as if it wanted to grab hold of you and throw you into the seemingly-bottomless gorge."
			else
				(gMessager say: 6 1 3) ; "A tall oak tree spreads its branches across the cliff edge."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fTowerWindow of Feature
	(properties
		noun 7
		nsLeft 151
		nsTop 92
		nsRight 176
		nsBottom 127
		sightAngle 180
		x 163
		y 109
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if local1
				(gMessager say: 7 1 3) ; "The gatekeeper is a gaunt, tired-looking man with deepset eyes that stare intelligently at you."
			else
				(gMessager say: 7 1 2) ; "The tower is empty. The gatekeeper is nowhere to be seen."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fParapet of Feature
	(properties
		noun 8
		nsLeft 119
		nsTop 11
		nsRight 192
		nsBottom 37
		sightAngle 180
		x 155
		y 121
		z 97
	)
)

(instance fTower of Feature
	(properties
		noun 9
		nsLeft 124
		nsTop 1
		nsRight 187
		nsBottom 154
		sightAngle 180
		x 155
		y 77
	)
)

(instance fArchWay of Feature
	(properties
		noun 10
		nsLeft 45
		nsTop 31
		nsRight 124
		nsBottom 59
		sightAngle 180
		x 84
		y 100
		z 55
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if [gEgoStats 11] ; climbing
				(gMessager say: 10 1 4) ; "The archway above the gate is tall, but looks climbable."
			else
				(gMessager say: 10 1 0 0) ; "A broad stone archway spans the gate."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance keeperTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 66 0)) ; keeperTalker
	)

	(method (showCases)
		(super
			showCases:
				43 ; Name
				(not (IsFlag 86))
				47 ; Boris
				(and (IsFlag 86) (not (IsFlag 122)) (== local2 1))
				44 ; Boris
				(and (IsFlag 122) (IsFlag 86))
				45
				(and (not (IsFlag 122)) (IsFlag 86) (== local2 3))
				46 ; Boris
				(and (not (IsFlag 122)) (IsFlag 86) (== local2 2))
				48 ; Wife
				(and (== global418 1) (not local8))
				49 ; Wife
				(or (== global418 2) (and (== global418 3) local10))
				86 ; Wife
				(and (== global418 3) (not local10))
				50 ; Wife
				(or (== global418 4) (and local10 (== global418 5)))
				87 ; Wife
				(and (== global418 5) (not local10))
				51 ; Wife
				(or (== global418 6) (and local10 (== global418 7)))
				88 ; Wife
				(and (== global418 7) (not local10))
				52 ; Wife
				(or (== global418 8) (and local10 (== global418 9)))
				53 ; Wife
				(and (== global418 9) (not local10))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(48 ; Wife
				(gEgo addHonor: 50)
				(= local8 1)
			)
			(49 ; Wife
				(if (not local9)
					(= local9 1)
					(gEgo addHonor: 50)
				)
			)
			(86 ; Wife
				(if (not local9)
					(= local9 1)
					(gEgo addHonor: 50)
				)
			)
			(50 ; Wife
				(if (not local9)
					(= local9 1)
					(gEgo addHonor: 50)
				)
			)
			(87 ; Wife
				(if (not local9)
					(= local9 1)
					(gEgo addHonor: 50)
				)
			)
			(51 ; Wife
				(if (not local9)
					(= local9 1)
					(gEgo addHonor: 50)
				)
			)
			(88 ; Wife
				(if (not local9)
					(= local9 1)
					(gEgo addHonor: 50)
				)
			)
			(52 ; Wife
				(if (not local9)
					(= local9 1)
					(gEgo addHonor: 50)
				)
			)
			(53 ; Wife
				(if (not local9)
					(= local9 1)
					(gEgo addHonor: 50)
				)
			)
			(43 ; Name
				(SetFlag 86)
			)
		)
		(super sayMessage: &rest)
	)
)

(instance heroTeller of Teller
	(properties)

	(method (showCases)
		(super
			showCases:
				48 ; Talk About Olga
				(and (== global418 1) (not local8))
				49 ; Talk About Olga
				(and (== global418 2) (IsFlag 85))
				50 ; Talk About Olga
				(and (== global418 4) (IsFlag 85))
				51 ; Talk About Olga
				(and (== global418 6) (IsFlag 85))
				52 ; Talk About Olga
				(and (== global418 8) (IsFlag 85))
				59 ; Tell About Yourself
				(or (== local0 2) (== local0 3))
				65 ; Talk About Yourself
				(or (== local0 4) (== local0 5))
				60
				(or (== local0 4) (== local0 5))
				33 ; Confess to Break-In
				(IsFlag 122)
				58
				(IsFlag 122)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(48 ; Talk About Olga
				(gEgo addHonor: 50)
				(= local8 1)
			)
			(49 ; Talk About Olga
				(gEgo addHonor: 50)
				(= local10 1)
				(= global418 3)
			)
			(50 ; Talk About Olga
				(gEgo addHonor: 50)
				(= local10 1)
				(= global418 5)
			)
			(51 ; Talk About Olga
				(gEgo addHonor: 50)
				(= local10 1)
				(= global418 7)
			)
			(52 ; Talk About Olga
				(gEgo addHonor: 50)
				(= local10 1)
				(= global418 9)
			)
		)
		(super sayMessage: &rest)
	)
)

(instance gateTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				19 ; Climb Over Gate
				[gEgoStats 11] ; climbing
				10 ; Climb Over Gate
				[gEgoStats 11] ; climbing
				23 ; Pick Lock on Gate
				(and (== gHeroType 2) [gEgoStats 9] (gEgo has: 24)) ; Thief, pick locks, theToolkit
				18 ; Pick Lock on Gate
				(and (== gHeroType 2) [gEgoStats 9] (gEgo has: 24)) ; Thief, pick locks, theToolkit
				17 ; Force Gate Open
				(or (== gHeroType 3) (== gHeroType 0)) ; Paladin, Fighter
				20 ; Force Gate Open
				(or (== gHeroType 3) (== gHeroType 0)) ; Paladin, Fighter
		)
	)

	(method (sayMessage)
		(switch iconValue
			(10 ; Climb Over Gate
				(gEgo trySkill: 11) ; climbing
				(self clean:)
				(gCurRoom setScript: sClimbTheGate)
			)
			(17 ; Force Gate Open
				(gEgo trySkill: 0) ; strength
				(if (== (gEgo trySkill: 0 325) 1) ; strength
					(self clean:)
					(gCurRoom setScript: sForceGate)
				else
					(super sayMessage: 11 4 13 &rest) ; You aren't strong enough to force the gate open.
				)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance katrinaTeller of Teller
	(properties
		title 1
		actionVerb 2
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 68 0)) ; katrinaTalker
	)

	(method (showCases)
		(super showCases: 66 [gEgoStats 12]) ; magic
	)

	(method (sayMessage)
		(if (== local6 3)
			(self clean:)
			(gCurRoom setScript: sKatrinaWalksAway)
		else
			(++ local6)
			(super sayMessage: &rest)
		)
	)
)

(instance specialEFtr of Feature
	(properties)

	(method (init)
		(if (not (gCurRoom exitList:))
			(gCurRoom exitList: (List new:))
		)
		((gCurRoom exitList:) add: self)
	)

	(method (onMe param1 param2)
		(if (and (<= nsLeft param1 nsRight) (<= nsTop param2 nsBottom))
			(if (and approachX approachY)
				(gCurRoom south: 552)
				(gEgo setMotion: ((ScriptID 17) new:) approachX approachY) ; pOffMover
			)
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance zappedSound of Sound
	(properties
		number 968
		loop -1
	)
)

(instance sndNecRoar of Sound
	(properties
		number 872
	)
)

(instance sndSwish of Sound
	(properties
		number 967
	)
)

(instance sndMetalGate of Sound
	(properties
		number 972
	)
)

(instance sndLightning of Sound
	(properties
		number 974
	)
)

