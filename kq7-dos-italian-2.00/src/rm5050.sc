;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5050)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm5050 0
	bullTalker 1
)

(local
	local0
)

(instance rm5050 of KQRoom
	(properties
		noun 2
		picture 5050
		edgeS 190
	)

	(method (init)
		((ScriptID 13 0) ; aEgoTalker
			view: -1
			loop: -1
			clientCel: -2
			mouth_x: -999
			mouth_y: -999
		)
		(cond
			((== gChapter 4)
				(gKqMusic1 number: 5062 loop: -1 play:)
			)
			((IsFlag 109)
				(gKqMusic1 number: 50501 loop: -1 play:)
			)
			(else
				(gKqMusic1 number: 5050 loop: -1 play:)
			)
		)
		(if (gEgo has: 42) ; China_Bird
			(SetFlag 432)
			(SetFlag 433)
			(SetFlag 431)
		)
		(sExit init:)
		((ScriptID 7001 0) client: bird hide_mouth: 1) ; kingTalker
		(super init:)
		(SetFlag 21)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 262 110 225 114 152 107 114 90 63 90 24 107 135 188 191 188 286 123
					yourself:
				)
		)
		(Load rsMESSAGE 5050)
		(gEgo
			init:
			normalize: 3
			posn: 175 165
			setScaler: Scaler 88 85 141 50
		)
		(bull yStep: 2 init:)
		(cond
			((== gValOrRoz -3) ; Roz
				(bull view: 5054 loop: 0 posn: 163 66 setPri: -1)
				(bird view: 5057 loop: 0 setPri: 60 posn: 100 35 init:)
			)
			((IsFlag 109)
				(bull view: 5053 loop: 6 cel: 0)
				(bird view: 5057 loop: 0 setPri: 70 init:)
			)
			(else
				(theMask init:)
			)
		)
		(if (and (IsFlag 117) (not (IsFlag 109)))
			(birdCage init:)
		)
		(if
			(or
				(and (== gValOrRoz -4) (not (IsFlag 142))) ; Val
				(and (== gValOrRoz -3) (not (IsFlag 143))) ; Roz
			)
			(china1 init:)
		)
		(gMouseDownHandler add: bull)
		(gCurRoom setScript: sEnterRoom)
	)

	(method (newRoom)
		(gKqMusic1 fade:)
		((ScriptID 7001 0) client: 0 hide_mouth: 0) ; kingTalker
		(super newRoom: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: bull)
		(super dispose:)
	)
)

(instance sPreShowStatue of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(proc11_3 gEgo bull self)
			)
			(2
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 1 61 7 0 self) ; "(THINKS TO HERSELF)Perhaps I should get to know this fellow before I show him such a thing."
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowComb of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(proc11_3 gEgo bull self)
				(bull setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(2 0)
			(3
				(gEgo normalize:)
				(= cycles 3)
			)
			(4
				(gMessager say: 1 5 1 0 self) ; "(SADLY)My daughter was taken from me by strange magic. She is a pretty girl, with hair of gold and eyes of blue. Have you heard of her, shopkeeper?"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosLookAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 2 8 13 0 self) ; "(THINKS TO HERSELF)I don't think I've seen this much fancy stuff in the whole castle of Daventry!"
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurnRosella of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo bull self)
			)
			(1
				(= cycles 3)
			)
			(2
				(gEgo normalize:)
				(gMessager say: 1 8 register 1 self)
			)
			(3
				(bull setCycle: End self)
			)
			(4
				(gMessager
					sayRange:
						1
						8
						register
						2
						(switch register
							(13 2)
							(14 4)
							(15 3)
						)
						self
				)
			)
			(5
				(bull setCycle: Beg self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo normalize:)
				(proc11_3 gEgo bird self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gEgo normalize:)
				(gMessager say: 3 8 22 1 self) ; "Hello, Treasure. How are you?"
			)
			(4
				(bird loop: 2 cel: 0 cycleSpeed: 10 setCycle: End self)
				(bullCry number: 5063 loop: 1 play: self)
			)
			(5 0)
			(6
				(bird loop: 0 cel: 0)
				(proc11_3 gEgo bull self)
			)
			(7
				(= cycles 3)
			)
			(8
				(gEgo normalize:)
				(gMessager say: 3 8 22 2 self) ; "She's just fine, my lady, thanks to you."
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBirdWave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 119 95 self)
			)
			(1
				(proc11_3 gEgo bird self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gEgo view: 5058 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(bird loop: 0 cel: 0 cycleSpeed: 10 setCycle: End self)
				(gEgo setCycle: Beg)
				(bullCry number: 819 loop: 1 play: self)
			)
			(5 0)
			(6
				(= ticks 90)
			)
			(7
				(bird setCycle: Beg self)
			)
			(8
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBullLookUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(if 0
					(bullCry number: 5051 loop: -1 play: self)
					(bull view: 5051 loop: 0 cel: 0 setCycle: Fwd)
				else
					(= cycles 1)
				)
			)
			(2
				(bull setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(3
				(bull setCycle: Beg self)
			)
			(4
				(bull setLoop: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChap5Open of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gMessager say: 0 0 17 0 self) ; "(VERY CHEERFUL)Hello, hello! Look, it's our hero, Treasure!"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sIntroScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bull setCycle: End self)
			)
			(1
				(gMessager say: 0 0 12 0 self) ; "Hello, lovely lady. I am Fernando Bullforth, proprietor of this shop. Let me know if I can help you with anything."
			)
			(2
				(bull setCycle: Beg self)
			)
			(3
				(SetFlag 434)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: PolyPath 175 115 self)
				(doorSound number: 802 loop: 1 play:)
			)
			(2
				(gCurRoom edgeS: 136)
				(cond
					((and (== gChapter 5) (not (IsFlag 200)))
						(client setScript: sChap5Open)
					)
					((and (== gValOrRoz -3) (not (IsFlag 434))) ; Roz
						(client setScript: sIntroScript)
					)
					((IsFlag 109)
						(gGame handsOn:)
						(self dispose:)
					)
					(else
						(client setScript: sBullLookUp)
					)
				)
			)
		)
	)
)

(instance sGiveBird of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(= cycles 3)
				)
				(1
					(gGame handsOff: 1)
					(Load rsVIEW 5053)
					(proc11_3 gEgo bull self)
					(bull setLoop: 1 1 setCel: 0 setCycle: End self)
				)
				(2 0)
				(3
					(= cycles 3)
				)
				(4
					(gEgo normalize:)
					(gMessager sayRange: 1 56 0 1 2 self) ; "(HAPPY)I know someone who'd really like to see you, Fernando."
				)
				(5
					(gEgo
						view: 5051
						loop: 4
						cel: 0
						x: (+ (gEgo x:) 16)
						setScaler: 0
						scaleX: 128
						scaleY: 128
					)
					(gEgo setCycle: CT (- (gEgo lastCel:) 2) 1 self)
					(bull loop: 6 cel: 0 setCycle: End self)
					(gKqMusic1 fade:)
				)
				(6 0)
				(7
					(bull view: 5051 loop: 5 cel: 0 setCycle: End self)
				)
				(8
					(gMessager say: 1 56 0 3 self) ; "(OVERJOYED)TREASURE!"
				)
				(9
					(gKqMusic1
						number: 50501
						loop: -1
						play:
						setVol: 0
						fade: 127 30 25 0
					)
					(gEgo put: 42 setCycle: CT 32 1 self) ; China_Bird
					(bird
						init:
						view: 5053
						loop: 0
						cel: 0
						posn: 178 79
						setPri: 100
						setCycle: End self
					)
				)
				(10 0)
				(11
					(bird dispose:)
					(gEgo
						x: (- (gEgo x:) 16)
						normalize: 6
						setScaler: Scaler 88 85 141 50
					)
					(bull view: 5053 loop: 1 cel: 0 setCycle: End self)
					(bullCry number: 5056 loop: 1 play: self)
				)
				(12 0)
				(13
					(bull loop: 3 cel: 0 setCycle: CT 1 1 self)
				)
				(14
					(gMessager say: 1 56 0 4 self) ; "(SINCERELY)I cannot thank you enough, good lady. Here, allow me to present you with this. It is my newest aquisition, and I want you to have it."
				)
				(15
					(bull setLoop: 2 cel: 0 setCycle: CT 6 1 self)
				)
				(16
					(theMask dispose:)
					(bull setCycle: End self)
				)
				(17
					(gMessager say: 1 56 0 5 self) ; "Thank you, Fernando. I will always remember you and Treasure."
				)
				(18
					(gEgo get: 43) ; Mask
					(bull view: 5053 loop: 1 cel: 0 setCycle: CT 7 1 self)
				)
				(19
					(gMessager say: 1 56 0 6 self) ; "If you will excuse me, my lady, I must go spend some quality time with Treasure. Yes, tell me all about it, my little precious one!"
				)
				(20
					(bull setCycle: End self)
				)
				(21
					(bull loop: 3 setPri: -1 cel: 0 setCycle: End self)
				)
				(22
					(bull
						setLoop: 7 1
						cel: 0
						cycleSpeed: 7
						setCycle: Fwd
						posn: 196 64
						setScaler: Scaler 100 68 63 34
						setMotion: MoveTo 202 60 self
					)
				)
				(23
					(bull setMotion: MoveTo 182 43 self)
				)
				(24
					(bull dispose:)
					(SetFlag 109)
					(birdCage dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(ClearFlag 539)
			(theMask dispose:)
			(gEgo put: 42 get: 43 setCycle: 0 normalize:) ; China_Bird, Mask
			(SetFlag 109)
			(birdCage dispose:)
			(bull dispose:)
			(bird dispose:)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sBullMove of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (or (gCurRoom script:) (gEgo script:))
			(bullCry stop:)
			(bull setCycle: 0)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bull view: 5051 loop: 0 cel: 0 setCycle: End self)
				(if (< (Random 0 50) 20)
					(bullCry number: 5052 loop: 1 play: self)
					(bull setCycle: Fwd)
					(self cue:)
				else
					(= ticks 1)
				)
			)
			(1 0)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sTalkBull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(proc11_3 gEgo bull self)
				(if (not (IsFlag 109))
					(bull view: 5051 setLoop: 1 1 setCel: 0 setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(2 0)
			(3
				(= cycles 5)
			)
			(4
				(gEgo normalize: 6)
				(if (or (== register 11) (== register 21))
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				else
					((ScriptID 13 0) view: 30800 loop: 6) ; aEgoTalker
				)
				(gMessager say: 1 8 register 0 self)
			)
			(5
				((ScriptID 13 0) view: -1 loop: -1 hide_mouth: 0) ; aEgoTalker
				(if (IsFlag 109)
					(= cycles 1)
				else
					(bull setCycle: Beg self)
				)
			)
			(6
				(if (not (IsFlag 109))
					(bull view: 5051 loop: 0 cel: 0 setCycle: Fwd)
					(bullCry number: 5052 loop: 1 play: self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(7
				(bull setCycle: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMoveToMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5053)
				(= cycles 3)
			)
			(1
				(gEgo view: 8151 loop: 0 cel: 0 setCycle: End self)
				(bull view: 5051 setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(2
				(gMessager sayRange: 4 8 5 1 2 self) ; "Pardon me, good sir, but what is the price of that lovely mask?"
			)
			(3
				(bull setCycle: Beg self)
			)
			(4
				(bull view: 5051 loop: 0 cel: 0 setCycle: Fwd)
				(bullCry number: 5053 loop: 1 play: self)
			)
			(5
				(bull setCycle: 0)
				(gMessager say: 4 8 5 3 self) ; "(DISSAPOINTED)Unfortunately, I've no money. Thank you anyway, shopkeep."
			)
			(6
				((ScriptID 13 0) view: -1) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(proc11_3 gEgo bull self)
				(bull view: 5051 setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(2 0)
			(3
				(gEgo normalize:)
				(= cycles 3)
			)
			(4
				(gMessager say: 3 8 6 0 self) ; "Your bird was stolen from your shop, right out of her cage?"
			)
			(5
				(bull setCycle: Beg self)
			)
			(6
				(bull view: 5051 loop: 0 cel: 0 setCycle: Fwd)
				(bullCry number: 5054 loop: 1 play: self)
			)
			(7
				(bull setCycle: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo view: 8151 setLoop: 1 cel: 0 setCycle: End self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(2
				(gMessager say: 2 8 5 0 self) ; "(THINKS TO HERSELF)These things are so lovely...but I'm afraid to even breathe in here! It all looks so fragile!"
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosFaceCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo bird self)
			)
			(1
				(= cycles 3)
			)
			(2
				(bull setCycle: End self)
			)
			(3
				(gEgo normalize:)
				(gMessager say: 3 8 13 0 self) ; "What a sweet little bird!"
			)
			(4
				(bull setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBirdFlutter of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (or (gCurRoom script:) (gEgo script:))
			(bullCry stop:)
			(bird loop: 0 cel: 0 setCycle: 0)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bird loop: 2 cel: 0 cycleSpeed: 10 setCycle: End self)
				(bullCry number: 5063 loop: 1 play: self)
			)
			(1
				(bird setLoop: 0 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance sShowStatue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo
					view: 5051
					x: (+ (gEgo x:) 16)
					setScaler: 0
					scaleX: 128
					scaleY: 128
					loop: 3
					cel: 0
					setCycle: End self
				)
				(bull view: 5051 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2 0)
			(3
				(gMessager say: 1 61 8 0 self) ; "I wonder if you could tell me something about this little statuette, Fernando?"
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(SetFlag 390)
				(gEgo
					normalize:
					x: (bull approachX:)
					setScaler: Scaler 88 85 141 50
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bull of Actor
	(properties
		noun 1
		approachX 167
		approachY 111
		x 194
		y 78
		priority 95
		fixPriority 1
		view 5051
	)

	(method (init)
		(super init:)
		(bullTalker client: self)
		(if (IsFlag 109)
			(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		else
			(self setHotspot: 8 10 56 5 61 approachVerbs: 8 56 5 61) ; Do, Exit, China_Bird, Golden_Comb, Magic_Statue, Do, China_Bird, Golden_Comb, Magic_Statue
		)
		(if (IsFlag 400)
			(self deleteHotVerb: 5) ; Golden_Comb
		)
	)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(== (gUser message:) 61)
				(IsFlag 390)
			)
			(return 0)
		)
		(return temp0)
	)

	(method (doit)
		(if
			(and
				(not (IsFlag 109))
				(not (gCurRoom script:))
				(not (gEgo script:))
				(not (bull script:))
				(<= (Random 10 200) 12)
			)
			(bull setScript: sBullMove)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(if
							(==
								(= temp0
									(cond
										((not (SetFlag 422)) 13)
										((not (SetFlag 423)) 14)
										((not (SetFlag 424)) 15)
										(else 16)
									)
								)
								16
							)
							(self setHotspot: 0)
							(gMessager say: 1 8 16 0) ; "(AS A SCARAB)Rosella! We have no time to waste! Let us hurry!"
						else
							(gCurRoom setScript: sTurnRosella 0 temp0)
						)
					)
					((== gChapter 5)
						(= temp0
							(cond
								((not (SetFlag 425)) 22)
								((not (SetFlag 426)) 19)
								((not (SetFlag 427)) 20)
								(else 21)
							)
						)
						(gCurRoom setScript: sTalkBull 0 temp0)
					)
					((IsFlag 109)
						(= temp0
							(cond
								((not (SetFlag 428)) 8)
								((not (SetFlag 429)) 9)
								((not (SetFlag 430)) 10)
								(else 11)
							)
						)
						(gCurRoom setScript: sTalkBull 0 temp0)
					)
					(else
						(if
							(==
								(= temp0
									(cond
										((not (SetFlag 431))
											(SetFlag 117)
											(birdCage init:)
											1
										)
										((not (SetFlag 432)) 2)
										((not (SetFlag 433)) 3)
										(else 4)
									)
								)
								4
							)
							(self deleteHotVerb: 8 10) ; Do, Exit
						)
						(gCurRoom setScript: sTalkBull 0 temp0)
					)
				)
			)
			(56 ; China_Bird
				(gCurRoom setScript: sGiveBird)
			)
			(5 ; Golden_Comb
				(self deleteHotVerb: 5) ; Golden_Comb
				(SetFlag 400)
				(gCurRoom setScript: sShowComb)
			)
			(61 ; Magic_Statue
				(gCurRoom setScript: sShowStatue)
			)
		)
	)
)

(instance bird of Prop
	(properties
		x 99
		y 35
		view 5053
	)

	(method (doit)
		(if
			(and
				(IsFlag 109)
				(not (gCurRoom script:))
				(not (bird script:))
				(== (Random 10 1000) 150)
			)
			(bird setScript: sBirdFlutter)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(birdCage doVerb: theVerb)
	)
)

(instance theMask of View
	(properties
		noun 4
		approachX 247
		approachY 116
		x 277
		y 58
		view 5051
		loop 7
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 144))
			(self approachVerbs: 8 10) ; Do, Exit
			(self setHotspot: 8 10) ; Do, Exit
		)
	)

	(method (doVerb)
		(self setHotspot: 0)
		(SetFlag 144)
		(gCurRoom setScript: sMoveToMask)
	)
)

(instance birdCage of Feature
	(properties
		noun 3
		nsLeft 79
		nsRight 113
		nsBottom 39
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 435))
			(self setHotspot: 8 10) ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(self setHotspot: 0)
						(bird setHotspot: 0)
						(SetFlag 435)
						(gCurRoom setScript: sRosFaceCage)
					)
					((and (IsFlag 109) (== gValOrRoz -4)) ; Val
						(if local0
							(gCurRoom setScript: sBirdWave)
						else
							(= local0 1)
							(gCurRoom setScript: sLookBird)
						)
					)
					(else
						(self setHotspot: 0)
						(SetFlag 435)
						(gCurRoom setScript: sLookCage)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance china1 of Feature
	(properties)

	(method (init)
		(china2 init:)
		(china3 init:)
		(china4 init:)
		(self onMeCheck: (china1Poly init:))
		(self setHotspot: 8 10) ; Do, Exit
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(china2 setHotspot: 0)
				(china3 setHotspot: 0)
				(china4 setHotspot: 0)
				(if (== gValOrRoz -4) ; Val
					(SetFlag 142)
					(gCurRoom setScript: sLookAround)
				else
					(SetFlag 143)
					(gCurRoom setScript: sRosLookAround)
				)
			)
		)
	)
)

(instance china1Poly of Polygon
	(properties)

	(method (init)
		(super init: 6 79 55 65 54 30 68 0 21 0 9 48)
		(return self)
	)
)

(instance china2 of Feature
	(properties)

	(method (init)
		(self onMeCheck: (china2Poly init:))
		(self setHotspot: 8 10) ; Do, Exit
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(china1 doVerb: theVerb)
			)
		)
	)
)

(instance china2Poly of Polygon
	(properties)

	(method (init)
		(super
			init: 58 59 59 80 118 78 158 99 227 106 219 77 163 68 138 55 67 53
		)
		(return self)
	)
)

(instance china3 of Feature
	(properties)

	(method (init)
		(self onMeCheck: (china3Poly init:))
		(self setHotspot: 8 10) ; Do, Exit
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(china1 doVerb: theVerb)
			)
		)
	)
)

(instance china3Poly of Polygon
	(properties)

	(method (init)
		(super init: 138 38 178 38 170 0 138 0)
		(return self)
	)
)

(instance china4 of Feature
	(properties)

	(method (init)
		(self onMeCheck: (china4Poly init:))
		(self setHotspot: 8 10) ; Do, Exit
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(china1 doVerb: theVerb)
			)
		)
	)
)

(instance china4Poly of Polygon
	(properties)

	(method (init)
		(super init: 244 3 235 36 262 38 268 75 301 90 293 0 256 0)
		(return self)
	)
)

(instance sExit of ExitFeature
	(properties
		nsLeft 107
		nsTop 125
		nsRight 236
		nsBottom 190
		approachX 171
		approachY 170
		x 171
		y 172
		exitDir 3
	)

	(method (doVerb)
		(gCurRoom setScript: leaveRoom)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 801 loop: 1 play: self)
			)
			(1
				(gCurRoom newRoom: 5300)
			)
		)
	)
)

(instance bullTalker of KQTalker
	(properties)
)

(instance bullCry of Sound
	(properties)
)

(instance doorSound of Sound
	(properties)
)

