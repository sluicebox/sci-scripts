;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use SQNarrator)
(use Print)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm200 0
	Djurkwhad 1
)

(local
	local0
	local1 = 5
	local2 = 3
	local3 = 8
	local4
	local5
	local6
	local7 = 9
	local8 = 1
)

(instance rm200 of SQRoom
	(properties
		noun 1
		picture 200
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 165 137 319 137 319 131 219 132 219 125 194 125 166 107 146 107 126 102 93 102 89 105 130 105
					yourself:
				)
		)
		(cond
			((== gPrevRoomNum 210)
				(gGame handsOff:)
				(gGSound1 setVol: 127)
				(gEgo
					init:
					posn: 290 136
					setScaler: Scaler 100 80 138 93
					normalize: 3
				)
				(cond
					((IsFlag 192)
						(ClearFlag 192)
						(if (IsFlag 4)
							(ClearFlag 4)
							(self setScript: sLetMeKnow)
						else
							(if (not (IsFlag 88))
								(djurkwhad
									init:
									approachVerbs: 2 4 ; Talk, Do
									setScript: sDjurkwhadJherky
								)
							)
							(gGame handsOn:)
						)
					)
					((and (IsFlag 7) (IsFlag 4))
						(ClearFlag 4)
						(self setScript: sRogerWins)
					)
					((and (IsFlag 6) (IsFlag 4))
						(ClearFlag 4)
						(self setScript: sRogerDies)
					)
					((and (IsFlag 5) (IsFlag 4))
						(ClearFlag 4)
						(djurkwhad
							view: 206
							setLoop: 0 1
							cel: 0
							init:
							posn: 291 115
							approachVerbs: 2 4 ; Talk, Do
							setScript: sJerkWins
						)
					)
					((IsFlag 88)
						(gGame handsOn:)
					)
					((not (IsFlag 4))
						(djurkwhad
							init:
							approachVerbs: 2 4 ; Talk, Do
							setScript: sDjurkwhadJherky
						)
					)
					(else
						(ClearFlag 4)
						(djurkwhad
							init:
							approachVerbs: 2 4 ; Talk, Do
							setScript: sDjurkwhadJherky
						)
					)
				)
			)
			((== gPrevRoomNum 330)
				(gGame handsOff:)
				(gEgo
					init:
					normalize:
					setScaler: Scaler 100 80 138 93
					enterRoom: 340 131 289 131
				)
				(if (not (IsFlag 88))
					(djurkwhad
						init:
						approachVerbs: 2 4 ; Talk, Do
						setScript: sDjurkwhadJherky
					)
				else
					(gGame handsOn:)
				)
			)
			(else
				(gGSound1 number: 200 loop: -1 play:)
				(gEgo
					init:
					normalize:
					setScaler: Scaler 100 80 138 93
					enterRoom: 340 131 289 131
				)
				(if (not (IsFlag 88))
					(djurkwhad
						init:
						approachVerbs: 2 4 ; Talk, Do
						setScript: sDjurkwhadJherky
					)
				else
					(gGame handsOn:)
				)
			)
		)
		(super init:)
		(Load rsVIEW 2052 206)
		(Palette 2 64 79 70) ; PalIntensity
		(PalCycle 0 87 97 -1 10) ; Start
		(PalCycle 0 98 103 -1 10) ; Start
		(PalCycle 0 154 159 -1 10) ; Start
		(gamePlayer2 init: approachVerbs: 4 setCycle: RandCycle) ; Do
		(fSmoker init:)
		(smoker init: approachVerbs: 4 setScript: sSmokerSmokes) ; Do
		(gameWatcher init: approachVerbs: 4) ; Do
		(eyesOfGW init: setScript: sEyesRoving)
		(helpMeSmoker init: setScript: sSmoke_r_Scratch)
		(spitter init: setScript: sSpitter)
		(vulture init:)
		(sitter init: setScript: sSitter)
		(if (Random 0 1)
			(gamePlayer1 init: approachVerbs: 4 setScript: sPlayerActions) ; Do
		else
			(alternate init: setCycle: RandCycle)
		)
		(sitDownGame init: approachVerbs: 4) ; Do
		(bigGame init: approachVerbs: 4) ; Do
		(monitor init: approachVerbs: 4) ; Do
		(lavaScreen init: approachVerbs: 4 setCycle: Fwd) ; Do
		(gameScreen init: approachVerbs: 4 setCycle: Fwd) ; Do
		(stoogeFighter init: approachVerbs: 4 setCycle: Fwd) ; Do
		(mario init: setPri: 200 setCycle: Fwd)
		(monitor init: approachVerbs: 4) ; Do
		(sitDownGame init: approachVerbs: 4) ; Do
		(bigGame init: approachVerbs: 4) ; Do
		(game2 init: approachVerbs: 4) ; Do
		(game3 init: approachVerbs: 4) ; Do
		(game3Screen init: approachVerbs: 4) ; Do
		(exit330 init: gTheExitECursor approachVerbs: 7) ; ExitRight
	)

	(method (dispose)
		(Palette 2 60 79 100) ; PalIntensity
		(super dispose:)
	)
)

(instance sEyesRoving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eyesOfGW setCycle: Fwd)
				(= ticks (proc0_8 60 120))
			)
			(1
				(eyesOfGW cel: 0)
				(= ticks 60)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sSitter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sitter loop: 0 setCycle: RandCycle)
				(= ticks (Random 240 480))
			)
			(1
				(sitter loop: 1 setCycle: Fwd)
				(= ticks (Random 60 180))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sSmoke_r_Scratch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self changeState: (Random 0 3))
			)
			(1
				(helpMeSmoker view: 202 loop: 1 cel: 0 setCycle: RandCycle)
				(= ticks (Random 60 500))
			)
			(2
				(helpMeSmoker view: 202 setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance sSpitter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self changeState: (Random 0 7))
			)
			(1
				(spitter view: 203 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(= ticks (Random 60 120))
			)
			(3
				(self changeState: (Random 0 7))
			)
			(4
				(head init: view: 203 loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(head dispose:)
				(= ticks (Random 60 120))
			)
			(6
				(self changeState: (Random 0 7))
			)
			(7
				(spitter view: 203 loop: 2 cel: 0 setCycle: End self)
			)
			(8
				(vulture view: 203 loop: 3 cel: 0 setCycle: End self)
			)
			(9
				(self changeState: (Random 0 7))
			)
		)
	)
)

(instance sSmokerSmokes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (proc0_8 3 6))
			)
			(1
				(smoker setCycle: End self)
			)
			(2
				(smoker setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sPlayerActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gamePlayer1
					setCel: 0
					setLoop: 0
					cycleSpeed: 15
					setCycle: RandCycle
				)
				(= seconds (proc0_8 8 26))
			)
			(1
				(gameScreen loop: 3 cel: 0 cycleSpeed: 25 setCycle: End)
				(gamePlayer1 setCel: 0 setCycle: End)
				(= seconds 1)
			)
			(2
				(gamePlayer1
					setCel: 0
					setLoop: 1
					cycleSpeed: 13
					setCycle: End self
				)
			)
			(3
				(gameScreen loop: 2 cel: 0 cycleSpeed: 12 setCycle: Fwd)
				(self changeState: 0)
			)
		)
	)
)

(instance sDjurkwhadJherky of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(and (not local5) (Random 0 1))
						(and (== gPrevRoomNum 210) (IsFlag 4))
					)
					(djurkwhad
						posn: 291 115
						view: 206
						setLoop: 0 1
						cel: 0
						setCycle: Fwd
					)
					(= local5 0)
					(= local3 7)
				else
					(djurkwhad
						posn: 211 124
						view: 2051
						cel: 0
						loop: (Random 0 1)
						setCycle: Fwd
					)
					(= local3 8)
				)
				(= seconds (Random 2 5))
			)
			(1
				(if (== local3 7)
					(djurkwhad
						view: 2052
						loop: 1
						cel: 0
						setCycle: Walk
						setMotion: PolyPath 211 124 self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if (== local3 7)
					(djurkwhad
						view: 2051
						cel: 5
						setLoop: 2 1
						cycleSpeed: 9
						setCycle: Beg self
					)
					(= local3 8)
				else
					(= cycles 1)
				)
				(gGame handsOn:)
			)
			(3
				(djurkwhad
					view: 2051
					posn: 211 124
					cel: 0
					loop: (proc0_8 0 1)
					setCycle: End self
				)
			)
			(4
				(self changeState: 3)
			)
		)
	)
)

(instance sRogerDenied of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(if local8
					(gMessager say: 19 0 16 0 self) ; "Not now, thanks."
				else
					(= local8 1)
					(= cycles 1)
				)
			)
			(1
				(djurkwhad
					view: 2051
					cel: 5
					setLoop: 2 1
					cycleSpeed: 9
					setCycle: Beg self
				)
			)
			(2
				(djurkwhad
					posn: 211 124
					view: 2051
					cel: 0
					loop: (Random 0 1)
					setCycle: Fwd
				)
				(= ticks (Random 30 60))
			)
			(3
				(self changeState: 2)
			)
		)
	)
)

(instance sRogerTalksToJerk of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 325)
				(sDjurkwhadJherky dispose:)
				(= cycles 1)
			)
			(1
				(if (== local3 7)
					(djurkwhad setMotion: MoveTo 211 124 self)
				else
					(djurkwhad
						view: 2051
						setLoop: 2 1
						cel: 0
						setCycle: End self
					)
				)
			)
			(2
				(djurkwhad view: 205 loop: 8 cel: 0 setCycle: End self)
			)
			(3
				(djurkwhad view: 207 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(djurkwhad view: 205 loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gMessager say: 19 2 2 0 self) ; "So this is Stooge Fighter 3. Doesn't look so tough to me."
			)
			(6
				(= cycles 3)
			)
			(7
				(gGame setCursor: gNormalCursor 1)
				(if
					((Print new:)
						addBitmap: 2070 0 0
						addButtonBM: 2070 1 0 1 { } 11 3
						addButtonBM: 2070 2 0 0 { } 4 14
						init:
					)
					(= next sRogerAccepts)
				else
					(= local5 1)
					(= next sRogerDenied)
				)
				(= cycles 1)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLetMeKnow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(djurkwhad
					view: 206
					setLoop: 0 1
					cel: 0
					posn: 291 115
					setCycle: Fwd
					init:
				)
				(= cycles 3)
			)
			(1
				(djurkwhad
					view: 206
					setLoop: 0 1
					cel: 0
					posn: 291 115
					setCycle: Fwd
				)
				(= ticks 120)
			)
			(2
				(djurkwhad
					view: 2052
					loop: 1
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 211 124 self
				)
			)
			(3
				(djurkwhad view: 205 cel: 0 setLoop: 1 1)
				(= ticks 60)
			)
			(4
				(gEgo setHeading: 325)
				(gMessager say: 19 2 12 0 self) ; "Uh, let me know when you're ready to play, little buddy."
			)
			(5
				(djurkwhad
					view: 2051
					cel: 5
					setLoop: 2 1
					cycleSpeed: 9
					setCycle: Beg self
				)
			)
			(6
				(djurkwhad
					posn: 211 124
					view: 2051
					cel: 0
					loop: (Random 0 1)
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerAccepts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 4)
				(if (== (djurkwhad script:) sDjurkwhadJherky)
					(sDjurkwhadJherky dispose:)
				)
				(= cycles 1)
			)
			(1
				(if (== local3 8)
					(= cycles 1)
				else
					(djurkwhad
						view: 2052
						loop: 1
						cel: 0
						setCycle: Walk
						setMotion: PolyPath 211 124 self
					)
				)
			)
			(2
				(djurkwhad view: 205 loop: 8 cel: 0 setCycle: End self)
			)
			(3
				(djurkwhad view: 205 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(cond
					((and (not (IsFlag 5)) (not (IsFlag 7)))
						(gMessager say: 19 2 8 0 self) ; "Gosh, Mr. Djurkwhad. That, ah, that sounds neat."
					)
					((gEgo has: 18) ; Cheat_Sheet
						(gMessager sayRange: 19 2 4 9 12 self) ; "Oh, this is gonna be fun! You're a bit puny but I'm sure I'll be able to get a few buckazoids for you over at the slave colony."
					)
					(else
						(gMessager say: 19 2 5 0 self) ; "I've thought it over. I think I'll give it a try. Let's do it, Tentacle Head."
					)
				)
			)
			(5
				(gEgo setMotion: PolyPath 290 136 self)
			)
			(6
				(gEgo setHeading: 360)
				(djurkwhad
					view: 2052
					setLoop: 0 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 291 115 self
				)
			)
			(7
				(djurkwhad view: 206 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(8
				(gCurRoom newRoom: 210)
				(self dispose:)
			)
		)
	)
)

(instance sRogerWins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 10)
				(djurkwhad init: posn: 241 119 view: 208 loop: 0 cel: 0)
				(= cycles 1)
			)
			(1
				(SetFlag 88)
				(gEgo setMotion: PolyPath 197 120 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gMessager sayRange: 19 0 6 1 2 self) ; "How lucky can a guy get? That was pure luck! Geez!"
			)
			(4
				(gEgo moveSpeed: 12 setMotion: MoveTo 209 120 self)
			)
			(5
				(djurkwhad
					view: 208
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 10 1 self
				)
				(if (<= global150 0)
					(gEgo get: 13) ; Buckazoids
				)
				(+= global150 300)
			)
			(6
				(djurkwhad setCycle: End)
				(gEgo
					view: 2080
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(7
				(gEgo normalize: 0)
				((gInventory at: 13) select: 0 1) ; Buckazoids
				(gMessager sayRange: 19 0 6 3 4 self) ; "Here."
			)
			(8
				(djurkwhad setLoop: 1 1 setCycle: Fwd setMotion: MoveTo 340 121)
				(gEgo setMotion: DPath 210 131 340 131 self)
			)
			(9
				(gCurRoom newRoom: 330)
				(self dispose:)
			)
		)
	)
)

(instance sJerkWins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(djurkwhad setCycle: Fwd)
				(= ticks 120)
			)
			(2
				(djurkwhad
					view: 2052
					loop: 1
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 211 124 self
				)
			)
			(3
				(djurkwhad view: 205 cel: 0 setLoop: 1 1)
				(= ticks 60)
			)
			(4
				(gMessager say: 19 2 3 0 self) ; "Wow, Man. Guess I got real lucky, or maybe you were holding back on me. Nah, you wouldn't do that, would ya. You don't look that bri... I mean, that probably isn't your style."
			)
			(5
				(djurkwhad view: 207 loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(= cycles 5)
			)
			(7
				(gGame setCursor: gNormalCursor 1)
				(if
					((Print new:)
						addBitmap: 2070 0 0
						addButtonBM: 2070 1 0 1 { } 11 3
						addButtonBM: 2070 2 0 0 { } 4 14
						init:
					)
					(= next sRogerAccepts)
				else
					(= local5 1)
					(= next sRogerDenied)
				)
				(= cycles 1)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCanCheat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 325)
				(djurkwhad
					view: 2051
					cel: 0
					setLoop: 2 1
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(1
				(djurkwhad view: 205 loop: 8 cel: 0 setCycle: End self)
			)
			(2
				(djurkwhad view: 207 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager sayRange: 19 2 4 1 7 self) ; "Hi, Mr. Djurkwhad. How about another game of Stooge Fighter? I'm feeling a little luckier this time."
			)
			(4
				(= cycles 5)
			)
			(5
				(gGame setCursor: gNormalCursor 1)
				(if
					((Print new:)
						addBitmap: 2070 0 0
						addButtonBM: 2070 1 0 1 { } 11 3
						addButtonBM: 2070 2 0 0 { } 4 14
						init:
					)
					(= next sRogerAccepts)
				else
					(= local5 1)
					(= next sRogerDenied)
				)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPlaysSecond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== local6 1)
					(= local6 0)
					(= cycles 1)
				else
					(djurkwhad
						view: 2051
						cel: 0
						setLoop: 2 1
						cycleSpeed: 9
						setCycle: End self
					)
				)
			)
			(1
				(djurkwhad view: 205 loop: 8 cel: 0 setCycle: End self)
			)
			(2
				(djurkwhad view: 205 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setHeading: 325)
				(gMessager say: 19 2 3 2 self) ; "Wanna play again? (PUT UP YES/NO DIALOG)"
			)
			(4
				(= cycles 5)
			)
			(5
				(gGame setCursor: gNormalCursor 1)
				(if
					((Print new:)
						addBitmap: 2070 0 0
						addButtonBM: 2070 1 0 1 { } 11 3
						addButtonBM: 2070 2 0 0 { } 4 14
						init:
					)
					(= next sRogerAccepts)
				else
					(= local5 1)
					(= next sRogerDenied)
				)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(djurkwhad
					posn: 291 115
					view: 206
					setLoop: 0 1
					cel: 0
					setCycle: Fwd
					init:
				)
				(= ticks 120)
			)
			(1
				(djurkwhad
					view: 2052
					loop: 1
					cel: 0
					setCycle: Fwd
					setMotion: PolyPath 211 124 self
				)
			)
			(2
				(djurkwhad view: 205 loop: 8 cel: 0 setCycle: End self)
			)
			(3
				(djurkwhad view: 205 loop: 1 cel: 0)
				(= ticks 60)
			)
			(4
				(gEgo init: posn: 290 136 normalize: 3)
				(gMessager say: 19 0 7 0 self) ; "Hey, this guy's good! You can kiss this game goodbye."
			)
			(5
				(= local6 1)
				(= local8 0)
				(djurkwhad setScript: sRogerDenied)
				(ClearFlag 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 140 self)
			)
			(1
				(gCurRoom newRoom: 330)
				(self dispose:)
			)
		)
	)
)

(instance helpMeSmoker of Prop
	(properties
		x 68
		y 149
		view 202
		loop 1
	)
)

(instance spitter of Prop
	(properties
		noun 23
		x 128
		y 128
		view 203
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)
)

(instance vulture of Prop
	(properties
		noun 24
		x 148
		y 145
		view 203
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)
)

(instance sitter of Prop
	(properties
		noun 22
		sightAngle 40
		x 82
		y 122
		view 204
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 135 ignoreActors: 1)
	)
)

(instance alternate of Prop
	(properties
		noun 20
		x 66
		y 108
		view 204
		loop 2
		cel 2
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)
)

(instance head of Prop
	(properties
		noun 23
		x 136
		y 94
		view 203
		loop 1
		cel 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 140 ignoreActors: 1)
	)
)

(instance djurkwhad of Actor
	(properties
		noun 19
		sightAngle 40
		approachX 261
		approachY 136
		x 211
		y 124
		view 2051
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== local1 5)
					(gMessager say: 19 1 1) ; "Now that's an interesting specimen. Is this place the backwoods of the universe or what?"
				else
					(gMessager say: 19 1) ; "It's your new acquaintance, Djurkwhad."
				)
			)
			(2 ; Talk
				(cond
					((== global149 0)
						(= local1 6)
						(= global149 1)
						(self setScript: sRogerTalksToJerk)
					)
					((== global149 1)
						(if (gEgo has: 18) ; Cheat_Sheet
							(self setScript: sCanCheat)
						else
							(self setScript: sPlaysSecond)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stoogeFighter of Prop
	(properties
		noun 8
		sightAngle 40
		approachX 289
		approachY 131
		x 290
		y 90
		z 1
		priority 130
		fixPriority 1
		view 200
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 253 108 253 118 248 118 245 123 247 128 255 130 319 130 320 99 310 86 306 78 303 74 280 74 276 77 272 86 260 86 255 88 232 107
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 8 4) ; "(GO TO THE GAME)"
				(gCurRoom newRoom: 210)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mario of Prop
	(properties
		x 166
		y 21
		view 200
		loop 1
	)
)

(instance gameScreen of Prop
	(properties
		noun 4
		approachX 88
		approachY 106
		x 65
		y 81
		view 201
		loop 2
		signal 20513
		cycleSpeed 12
	)
)

(instance gamePlayer1 of Prop
	(properties
		noun 2
		approachX 88
		approachY 106
		x 66
		y 105
		view 201
		signal 20513
		cycleSpeed 12
	)
)

(instance gamePlayer2 of Prop
	(properties
		noun 3
		approachX 169
		approachY 99
		x 134
		y 102
		view 2010
		signal 20513
		cycleSpeed 15
	)

	(method (init)
		(self setPri: 100)
		(super init:)
	)
)

(instance gameWatcher of Prop
	(properties
		noun 7
		approachX 204
		approachY 117
		x 199
		y 114
		view 2011
		loop 1
		signal 20513
		cycleSpeed 15
	)
)

(instance eyesOfGW of Prop
	(properties
		noun 7
		x 191
		y 73
		view 2011
		loop 2
		signal 20513
		cycleSpeed 15
	)

	(method (init)
		(self setPri: 115)
		(super init:)
	)
)

(instance lavaScreen of Prop
	(properties
		noun 5
		approachX 282
		approachY 131
		x 282
		y 143
		z 100
		view 2011
		signal 20513
		cycleSpeed 15
	)

	(method (init)
		(self setPri: 150)
		(super init:)
	)
)

(instance smoker of Prop
	(properties
		noun 6
		approachX 64
		approachY 115
		x 49
		y 110
		view 202
		signal 20513
		cycleSpeed 12
	)
)

(instance fSmoker of Feature
	(properties
		noun 21
		sightAngle 40
		x 57
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 91 53 91 46 96 39 105 45 117 48 123 48 140 57 139 60 122 64 117 73 118 76 115 67 112 63 104 71 105 73 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance monitor of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 282
		approachY 131
		x 298
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 45 301 55 314 52 316 46 315 7 297 0 293 0 274 12
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sitDownGame of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 108
		approachY 135
		x 108
		y 114
		z 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 27 123 42 135 132 135 139 129 150 126 151 123 151 109 137 100 90 100 59 108 41 108 26 116
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bigGame of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 233
		approachY 117
		x 233
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 109 215 115 253 114 253 102 268 96 275 73 294 73 294 40 275 40 259 24 255 25 238 10 226 15 213 25 200 27 181 46 181 82 203 99 203 101 191 105
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance game2 of Feature
	(properties
		noun 12
		nsLeft 126
		nsTop 44
		nsRight 159
		nsBottom 96
		sightAngle 40
		approachX 169
		approachY 99
		x 134
		y 102
	)
)

(instance game3 of Feature
	(properties
		noun 13
		nsLeft 162
		nsTop 51
		nsRight 193
		nsBottom 95
		sightAngle 40
		approachX 187
		approachY 98
		x 173
		y 94
	)
)

(instance game3Screen of Feature
	(properties
		noun 14
		nsLeft 162
		nsTop 20
		nsRight 182
		nsBottom 41
		sightAngle 40
		approachX 187
		approachY 98
		x 173
		y 94
	)
)

(instance exit330 of ExitFeature
	(properties
		nsLeft 310
		nsTop 80
		nsRight 320
		nsBottom 138
		nextRoom 330
		message 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; ExitRight
				(gCurRoom setScript: sExitScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Djurkwhad of SmallTalker
	(properties)

	(method (init)
		(cond
			((== local7 9)
				(djurkHead init:)
				(self talkView: 205 talkLoop: 3)
				(= client djurkHead)
			)
			((== local7 10)
				(self talkView: 208 talkLoop: 2)
				(= client djurkwhad)
			)
		)
		(super init:)
	)

	(method (realDispose)
		(super realDispose:)
		(if (and scratch (== local7 9))
			(djurkHead dispose:)
		)
	)
)

(instance djurkHead of Prop
	(properties
		x 215
		y 88
		view 205
		loop 3
	)

	(method (init)
		(self setPri: 200)
		(super init:)
	)
)

