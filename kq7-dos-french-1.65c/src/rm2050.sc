;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2050)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use scaryInvInit)
(use eastFeat)
(use useObj)
(use Talker)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2050 0
	forgerTalker 1
	jewelerTalker 2
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
)

(procedure (localproc_0 param1)
	(switch param1
		(99
			(tongs
				verb: param1
				myCursorView: 991
				myCursorLoop: 5
				myCursorCel: 3
			)
			(if (not (IsFlag 72))
				(mold init:)
			)
		)
		(96
			(tongs
				verb: param1
				myCursorView: 991
				myCursorLoop: 5
				myCursorCel: 5
			)
		)
	)
	(gTheUseObjCursor
		view: (tongs myCursorView:)
		loop: (tongs myCursorLoop:)
		cel: (tongs myCursorCel:)
	)
	(gUser message: param1)
	(= global331 0)
	(if (== gTheCursor gTheUseObjCursor)
		(gGame setCursor: gTheUseObjCursor 1)
	)
)

(instance rm2050 of KQRoom
	(properties
		picture 2050
	)

	(method (init)
		(super init:)
		(= local3 gFtrInitializer)
		(= gFtrInitializer roomFeatureInitCode)
		(gEgo init: normalize: setScaler: Scaler 100 76 136 101)
		(gCurRoom
			addObstacle:
				(if (and (IsFlag 67) (not (IsFlag 55)))
					((Polygon new:)
						type: PContainedAccess
						init: 320 80 305 80 312 98 274 106 251 113 251 117 224 117 180 117 142 110 136 90 230 90 230 86 150 86 146 80 130 80 138 111 71 111 62 101 34 101 34 137 236 137 320 103
						yourself:
					)
				else
					((Polygon new:)
						type: PContainedAccess
						init: 320 75 301 75 312 98 274 106 251 113 251 117 224 117 180 117 145 108 136 90 230 90 230 86 142 86 142 80 131 80 138 111 71 111 62 101 33 101 33 137 233 139 320 104
						yourself:
					)
				)
		)
		(forgeDoor init:)
		(shaftDoor init:)
		(oven init: setCycle: Fwd)
		(forger init:)
		(bellows init:)
		(mold init:)
		(moldyFeat init:)
		(mold dispose:)
		(tongs init:)
		(if
			(and
				(not (IsFlag 55))
				(not (gEgo has: 25)) ; Silver_Spoon
				(not (IsFlag 51))
			)
			(water init:)
		)
		(if (and (not (gEgo has: 38)) (not (IsFlag 388))) ; Hammer_and_Chisel
			(jeweler init:)
		)
		(switch gPrevRoomNum
			(2000
				(gEgo posn: 138 85 setHeading: 180 normalize: 2)
				(gCurRoom setScript: enterFromMine)
			)
			(else
				(gEgo posn: 302 108 setHeading: 225)
				(gCurRoom setScript: enterFromHall)
			)
		)
		(cond
			((and (gEgo has: 34) (not (IsFlag 363))) ; Wet_Sulfur
				(SetFlag 363)
				(Load 140 2058) ; WAVE
				(Load 140 836) ; WAVE
				(forger
					view: 20521
					setLoop: 0 1
					setCel: 0
					posn: 216 107
					setPri: 99
				)
				(forger setCycle: 0 setScript: 0)
				(hammer init:)
				(self setScript: spoonToon)
			)
			((and (IsFlag 363) (not (IsFlag 72)))
				(Load 140 2058) ; WAVE
				(Load 140 836) ; WAVE
				(mold init:)
			)
			((not (IsFlag 77))
				(SetFlag 77)
				(Load 140 2052) ; WAVE
				(forger setScript: firstCartoon)
			)
		)
		(= local8 (gEgo has: 36)) ; Lantern_with_Spark
		(if (not script)
			(gGame handsOn:)
		)
		(gKqMusic1 number: 2050 loop: -1 play:)
		((ScriptID 13 0) view: -1 loop: -1 hide_mouth: 0) ; aEgoTalker
	)

	(method (newRoom)
		(gKqMusic1 fade:)
		(Lock 140 2063 0) ; WAVE
		(= gFtrInitializer local3)
		(super newRoom: &rest)
	)

	(method (dispose)
		(anvilSound stop: dispose:)
		(sparksSound stop: dispose:)
		(jewelerSound stop: dispose:)
		(snoreSound stop: dispose:)
		(super dispose: &rest)
	)

	(method (setScript param1)
		(if (OneOf script enterFromMine enterFromHall)
			(script next: param1)
		else
			(super setScript: param1 &rest)
		)
	)
)

(instance enterFromMine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setCycle: Walk
					setLoop: 2 1
					posn: 154 92
					setPri: 10
					setMotion: MoveTo 143 79 self
				)
			)
			(1
				(gEgo setPri: -1 setLoop: -1 setMotion: MoveTo 140 83 self)
			)
			(2
				(gEgo normalize: 2)
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterFromHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 312 86 setMotion: MoveTo 317 97 self)
			)
			(1
				(gEgo setMotion: MoveTo 311 101 self)
			)
			(2
				(gEgo normalize: 5)
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance firstCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 2)
				(= cycles 1)
			)
			(1
				(forger
					view: 2051
					setLoop: 0
					cel: 0
					posn: 187 108
					setCycle: CT 3 1 self
				)
			)
			(2
				(if (> (-- register) 0)
					(-= state 2)
				)
				(anvilSound number: 2051 loop: 1 play:)
				(forger setCycle: End self)
			)
			(3
				(self setScript: forgerPumpsBellows self)
			)
			(4
				(forger setScript: forgerPounds setHotspot: 8 10) ; Do, Exit
				(self dispose:)
			)
		)
	)
)

(instance forgerPumpsBellows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(forger
					view: 20510
					setLoop: 0
					cel: 0
					posn: 209 98
					setPri: 99
					setCycle: CT 5 1 self
				)
			)
			(1
				(sparksSound number: 2052 loop: 1 play:)
				(forger
					view: 20510
					loop: 1
					cel: 0
					cycleSpeed: 6
					posn: 208 99
					setCycle: End self
				)
				(bellows
					view: 20510
					loop: 2
					cel: 0
					cycleSpeed: 6
					posn: 208 99
					setCycle: End
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(sparksSound stop:)
				(sparksSound loop: 1 play:)
				(forger
					view: 20510
					loop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
				(bellows cel: 0 cycleSpeed: 6 setCycle: End)
			)
			(4
				(sparks init:)
				(oven setCycle: 0)
				(= cycles 1)
			)
			(5
				(bellows view: 2050 loop: 1 cel: 0 x: 253 y: 88)
				(forger
					view: 20510
					setLoop: 0
					cel: 4
					setPri: 99
					setCycle: Beg self
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance forgerPounds of Script
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(forger
					view: 2051
					setLoop: 0
					cel: 0
					setPri: 109
					posn: 187 108
					setCycle: CT 3 1 self
				)
			)
			(1
				(cond
					(
						(and
							(not next)
							(not register)
							(not (gCast contains: sparks))
							(not (gTalkers size:))
							(not (gCurRoom script:))
							(not script)
						)
						(= cycles 1)
					)
					((and (not next) (not register))
						(-= state 2)
						(if (not (gTalkers size:))
							(anvilSound number: 2051 loop: 1 play:)
						)
						(forger setCycle: End self)
					)
					(else
						(if next
							(next caller: caller)
							(= caller 0)
						)
						(= register 0)
						(self setScript: 0)
						(self dispose:)
					)
				)
			)
			(2
				(forger setHotspot: 0)
				(self setScript: forgerPumpsBellows self)
			)
			(3
				(self setScript: forgerTimerScript)
				(forger setHotspot: 8 10) ; Do, Exit
				(self changeState: 0)
			)
		)
	)
)

(instance forgerTimerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance forgerRests of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(forger
					view: 20514
					setLoop: 0
					cel: 0
					posn: 198 108
					setCycle: End self
				)
			)
			(1
				(forger
					view: 20513
					setLoop: 1
					cel: 0
					posn: 182 106
					setCycle: CT 4 1 self
				)
			)
			(2
				(gKqSound1 number: 2054 loop: 1 play:)
				(forger view: 20513 setCel: 5 setCycle: End self)
			)
			(3
				(gKqSound1 stop:)
				(self dispose:)
			)
		)
	)
)

(instance snoreScript of Script
	(properties)

	(method (init)
		(Load 140 914) ; WAVE
		(= start 1)
		(super init: &rest)
		(= cycles 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(snoreSound stop:)
			)
			(1
				(forger view: 2059 setLoop: (IsFlag 78) 1)
				(if (IsFlag 78)
					(forger setLoop: 1 1 cel: 0 setCycle: CT 4 1 self)
				else
					(forger setLoop: 0 1 cel: 5 setCycle: End self)
				)
				(if (not (gTalkers size:))
					(snoreSound number: 903 loop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(2 0)
			(3
				(= seconds 2)
			)
			(4
				(if (IsFlag 78)
					(forger cel: 5 setCycle: End self)
				else
					(forger cel: 0 setCycle: CT 4 1 self)
				)
				(if (not (gTalkers size:))
					(snoreSound number: 904 loop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(5 0)
			(6
				(= state 0)
				(= seconds 2)
			)
		)
	)
)

(instance spoonToon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(forger
					view: 20521
					setLoop: 0 1
					setCel: 0
					posn: 216 107
					setPri: 99
					setCycle: End self
				)
			)
			(1
				(forger
					view: 20523
					setLoop: 0 1
					setCel: 0
					setCycle: CT 28 1 self
				)
			)
			(2
				(hammer dispose:)
				(forger setCycle: End self)
			)
			(3
				(mold init:)
				(bowl init: setPri: (+ (oven priority:) 1))
				(forger setScript: forgerPounds)
				(= cycles 1)
			)
			(4
				(gEgo setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pumpBellows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(= local4 (gEgo x:))
				(= local5 (gEgo y:))
				(gEgo
					view: 2058
					loop: 0
					cel: 0
					x: 241
					y: 94
					cycleSpeed: 6
					setScale: 0
					setCycle: End self
				)
				(bellows
					view: 2058
					loop: 1
					cel: 0
					x: 241
					y: 94
					cycleSpeed: 6
					setCycle: End self
				)
				(sparksSound number: 2052 loop: 1 play:)
			)
			(1
				(bellows view: 2050 loop: 1 cel: 0 x: 253 y: 88)
			)
			(2
				(sparks init:)
				(oven setCycle: 0)
				(gEgo
					normalize: 4
					posn: (bellows approachX:) (bellows approachY:)
					setScaler: Scaler 100 76 136 101
					setMotion: MoveTo local4 local5 self
				)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkForgerFirst of Script
	(properties)

	(method (init)
		(super init: &rest)
		(ClearFlag 539)
	)

	(method (dispose)
		(super dispose: &rest)
		(ClearFlag 539)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local4 (gEgo x:))
					(= local5 (gEgo y:))
					(proc11_3 gEgo forger self)
				)
				(1
					(forgerPounds caller: self next: forgerRests)
					(gMessager say: 1 8 1 1 self) ; "Pardon me, sir, but I was wondering..."
				)
				(2 0)
				(3
					(gGame handsOff: 1)
					(gMessager say: 1 8 1 2 self) ; "Well wonder no longer, sweet potata. I am da troll of yer dreams."
				)
				(4
					(gEgo hide:)
					(hammer
						view: 20513
						loop: 3
						cel: 0
						setPri: 150
						posn: 182 106
						init:
					)
					(forger
						view: 2052
						setLoop: 0
						cel: 0
						posn: 179 107
						setCycle: End self
					)
				)
				(5
					(forger setLoop: 1 cel: 0 posn: 179 108 setCycle: End self)
				)
				(6
					(forger view: 20525 setLoop: 2 cel: 0 setCycle: CT 6 1 self)
				)
				(7
					(gKqSound1 number: 2055 loop: 1 play:)
					(forger setCycle: CT 19 1 self)
				)
				(8
					((ScriptID 13 0) ; aEgoTalker
						client: forger
						view: 20525
						loop: 22
						clientCel: -2
					)
					(gMessager say: 1 8 1 3 self) ; "(ANGRY, THINKING FAST)Now see here! I'm--ah, I'm engaged to the KING! That's right, the king!"
				)
				(9
					(forger setCycle: End self)
				)
				(10
					((ScriptID 13 0) client: gEgo view: -1 loop: -1) ; aEgoTalker
					(forgerTalker clientCel: -2 loop: 23)
					(gMessager say: 1 8 1 4 self) ; "Oh! Well, I respect King Otar, you can bet on dat. I'm sorry, my little rutabaga, but our love is not to be. You let me know if he dumps ya, okay?"
				)
				(11
					(forgerTalker loop: -1)
					(forger
						setLoop: 3
						cel: 0
						posn: 171 107
						setCycle: CT 5 1 self
					)
				)
				(12
					(gKqSound1 number: 2056 loop: 1 play:)
					(forger setCycle: End self)
				)
				(13
					(gKqSound1 number: 895 loop: 1 play: self)
				)
				(14
					(gEgo
						view: 20525
						setLoop: 4 1
						cel: 0
						posn: 171 107
						show:
						setScale: 0
						setCycle: End self
					)
					(hammer dispose:)
					(forger setScript: forgerReturnFromRest self)
				)
				(15
					(gEgo
						posn: 150 106
						normalize: 2
						setScaler: Scaler 100 76 136 101
						setMotion: MoveTo local4 local5 self
					)
				)
				(16
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			((ScriptID 13 0) client: gEgo view: -1 loop: -1) ; aEgoTalker
			(hammer dispose:)
			(gEgo
				show:
				posn: local4 local5
				normalize: 2
				setScaler: Scaler 100 76 136 101
			)
			(forger setCycle: 0 setScript: forgerPounds)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance forgerReturnFromRest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(forger
					view: 20516
					setLoop: 2
					cel: 0
					posn: 182 109
					setCycle: End self
				)
			)
			(1
				(forger setScript: forgerPounds)
			)
		)
	)
)

(instance sparksFly of Script
	(properties)

	(method (doit)
		(if (and (gTalkers size:) (not local6))
			(= local6 1)
			(sparksSound stop:)
		)
		(if
			(and
				local6
				(< state 3)
				(not (gTalkers size:))
				(not (gCurRoom script:))
			)
			(= local6 0)
			(sparksSound number: 2063 loop: -1 play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 0)
				(sparksSound number: 2063 loop: -1 play:)
				(sparks setCycle: End self)
			)
			(1
				(sparks setCycle: ROsc -1 9 14)
				(= seconds 15)
			)
			(2
				(if register
					(-- state)
					(= seconds 1)
				else
					(sparksSound fade:)
					(sparks cel: 9 setCycle: Beg self)
				)
			)
			(3
				(sparksSound stop: loop: 0)
				(oven setCycle: Fwd)
				(sparks dispose:)
			)
		)
	)
)

(instance catchSpark of Script
	(properties)

	(method (init)
		(sparksFly register: 1)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 260 109 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo
					view: 2053
					setLoop: 1
					cel: 0
					posn: 280 112
					setScale: 0
					setCycle: End self
				)
			)
			(3
				(sparksFly register: 0)
				(if (< (sparks cel:) 9)
					(gMessager say: 2 43 2 1 self) ; "Oh, darn. I let it get too cold."
				else
					(gEgo put: 35) ; Lantern
					(gEgo get: 36) ; Lantern_with_Spark
					(bellows setHotspot: 0)
					(SetFlag 387)
					(= local8 (gEgo has: 36)) ; Lantern_with_Spark
					(= cycles 1)
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					normalize: 2
					setScaler: Scaler 100 76 136 101
					posn: 260 109
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance throwSulfur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2055)
				(Load rsVIEW 20550)
				(Load rsVIEW 20522)
				(Load 140 2060) ; WAVE
				(Load 140 2061) ; WAVE
				(Load 140 830) ; WAVE
				(Load 140 2062) ; WAVE
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 231 91 self)
			)
			(2
				(gEgo
					view: 2055
					loop: 0
					cel: 0
					posn: 231 91
					setPri: 97
					setScale: 0
					setCycle: End self
				)
			)
			(3
				(gEgo
					normalize: 4
					setScaler: Scaler 100 76 136 101
					setMotion: MoveTo 194 90 self
				)
				(UnLoad 128 2055)
			)
			(4
				(gEgo setHeading: 135 self)
			)
			(5
				(gKqSound1 number: 2060 loop: 1 play: self)
			)
			(6
				(UnLoad 140 2060)
				(if (forger script:)
					(forgerPounds register: 1 caller: self)
				else
					(= cycles 1)
				)
			)
			(7
				(forger
					view: 20522
					loop: 0
					cel: 0
					x: 186
					y: 104
					setPri: 98
					setCycle: CT 7 1 self
				)
			)
			(8
				(gKqSound1 number: 2061 loop: 1 play:)
				(forger
					view: 20553
					setLoop: 1 1
					setCel: 0
					posn: 239 102
					setPri: 98
					setCycle: End self
				)
				(UnLoad 128 20522)
			)
			(9
				(forger
					view: 20554
					setLoop: 2 1
					setCel: 0
					posn: 237 102
					setPri: 99
					setCycle: CT 14 1 self
				)
			)
			(10
				(smoke init: setCycle: End smoke)
				(forger setLoop: 2 1 setCel: 15)
				(forgerTalker clientCel: -2 loop: 23 modeless: 2)
				(gMessager say: 2 41 0 1 self) ; "What's dat, Mama? Time for bed? Okay! Nighty-night!"
			)
			(11
				(gKqSound1 number: 830 loop: 1 play:)
				(forger
					view: 20550
					setLoop: 3 1
					setCel: 0
					posn: 209 102
					setCycle: CT 6 1 self
				)
			)
			(12
				(gKqSound1 number: 2062 loop: 1 play: self)
				(UnLoad 140 830)
				(forger setCycle: End self)
			)
			(13 0)
			(14
				(SetFlag 67)
				(SetFlag 386)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 320 80 305 80 312 98 274 106 251 113 251 117 224 117 180 117 142 110 136 90 230 90 230 86 150 86 146 80 130 80 138 111 71 111 62 101 34 101 34 137 236 137 320 103
							yourself:
						)
				)
				(mold init: setHotspot: 8 10 99) ; Do, Exit, tongs
				(bellows setHotspot: 8 10 43 approachVerbs: 8) ; Do, Exit, Lantern, Do
				(forger setPri: 98 setScript: snoreScript)
				(gEgo setHeading: 180 self)
			)
			(15
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance kickForger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 (gEgo x:))
				(= local5 (gEgo y:))
				(gEgo hide:)
				(snoreSound stop: client: 0 loop: 0)
				(forger
					setScript: 0
					view: 20551
					setLoop: 0
					cel: 0
					posn: 163 106
					setCycle: CT 7 1 self
				)
			)
			(1
				(forgerTalker clientCel: -2)
				(gMessager say: 1 8 5 1 self) ; "Night, mama..."
			)
			(2
				(forger view: 20551 setCycle: CT 12 1 self)
			)
			(3
				((ScriptID 13 0) client: forger loop: 19 clientCel: -2) ; aEgoTalker
				(gMessager say: 1 8 5 2 self) ; "(AMUSED)Goodnight, you big goon."
			)
			(4
				((ScriptID 13 0) client: gEgo loop: -1 clientCel: -2) ; aEgoTalker
				(forger setCycle: End self)
			)
			(5
				(gEgo show: normalize: 0 posn: 154 107)
				(forger view: 20551 setLoop: 1 cel: 0 posn: 191 110)
				(= cycles 1)
			)
			(6
				(SetFlag 78)
				(forger setCycle: End self)
			)
			(7
				(forger setScript: snoreScript)
				(gEgo setMotion: MoveTo local4 local5 self)
			)
			(8
				(gEgo setHeading: 180 self)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jewelerWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 2 4))
				(= cycles 1)
			)
			(1
				(= cycles (Random 30 60))
			)
			(2
				(jeweler cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(jewelerSound number: 2053 loop: 1 play:)
				(jeweler setCycle: End self)
			)
			(4
				(if (not caller)
					(if (not (-- register))
						(self changeState: 0)
					else
						(self changeState: 2)
					)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance introduceToJeweler of Script
	(properties)

	(method (init)
		(super init: &rest)
		(ClearFlag 539)
	)

	(method (dispose)
		(super dispose: &rest)
		(ClearFlag 539)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(SetFlag 58)
					(gGame handsOff: 1)
					(Load 140 2067) ; WAVE
					(= cycles 1)
				)
				(1
					(if (jeweler script:)
						((jeweler script:) caller: self)
					else
						(= cycles 1)
					)
				)
				(2
					(sparksSound stop:)
					(gKqSound1 number: 2066 loop: 1 play: self)
				)
				(3
					(= local6 1)
					(jeweler
						view: 2057
						setLoop: 0 1
						setCel: 0
						posn: 45 87
						setCycle: CT 5 1 self
					)
				)
				(4
					(gKqSound1 number: 2067 loop: 1 play: self)
				)
				(5
					(jeweler setCycle: End self)
				)
				(6
					(gMessager say: 5 8 1 1 self) ; "Excuse me."
				)
				(7
					(jeweler setLoop: 1 cel: 0 posn: 47 88 setCycle: End self)
				)
				(8
					(gMessager sayRange: 5 8 1 2 9 self) ; "I didn't mean to startle you, sir. I am Rosella of Daventry."
				)
				(9
					(gMessager say: 5 8 15 0 self) ; "Pardon me, my dear, but I really must finish this project."
				)
				(10
					(jeweler setCycle: Beg self)
				)
				(11
					(jeweler setLoop: 0 cel: 20 posn: 45 88 setCycle: Beg self)
				)
				(12
					(jeweler
						view: 20512
						setLoop: 0
						cel: 0
						posn: 43 86
						setScript: jewelerWork
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(jeweler
				view: 20512
				setLoop: 0
				cel: 0
				posn: 43 86
				setScript: jewelerWork
			)
			(= local6 1)
			(SetFlag 58)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance askAboutMold of Script
	(properties)

	(method (init)
		(super init: &rest)
		(ClearFlag 539)
	)

	(method (dispose)
		(super dispose: &rest)
		(ClearFlag 539)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load 140 2067) ; WAVE
					(= cycles 1)
				)
				(1
					(if (jeweler script:)
						((jeweler script:) caller: self)
					else
						(= cycles 1)
					)
				)
				(2
					(gMessager say: 5 96 0 1 self) ; "(POLITELY BUT URGENTLY)Excuse me."
				)
				(3
					(jeweler
						view: 2057
						setLoop: 0 1
						setCel: 0
						posn: 45 87
						setCycle: End self
					)
				)
				(4
					(gMessager sayRange: 5 96 0 2 5 self) ; "(VERY STARTLED)Aaah! What?!"
				)
				(5
					(jeweler
						setLoop: 1 1
						setCel: 0
						posn: 47 88
						setCycle: End self
					)
				)
				(6
					(jeweler setCycle: Beg self)
				)
				(7
					(jeweler
						setLoop: 0
						setCel: 20
						posn: 45 88
						setCycle: Beg self
					)
				)
				(8
					(jeweler
						view: 20512
						setLoop: 0
						cel: 0
						posn: 43 86
						setScript: jewelerWork
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(jeweler
				view: 20512
				setLoop: 0
				cel: 0
				posn: 43 86
				setScript: jewelerWork
			)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance giveGem of Script
	(properties)

	(method (init)
		(super init: &rest)
		(ClearFlag 539)
	)

	(method (dispose)
		(super dispose: &rest)
		(ClearFlag 539)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gMessager say: 5 45 17 1 self) ; "Oppi, I have something I'd like to give you."
				)
				(1
					(jeweler
						view: 20571
						setLoop: 2
						cel: 0
						posn: 46 86
						setScript: 0
						setCycle: End self
					)
				)
				(2
					(gMessager sayRange: 5 45 17 2 4 self) ; "Ooooh! Oh my my! It's perfect! It's beautiful! How can I ever thank you? I'm forever in your debt! I'm going to throw out this horrible hammer and chisel, and get the best set money can buy!"
				)
				(3
					(jeweler setLoop: 3 cel: 0 posn: 47 86 setCycle: End self)
				)
				(4
					(gEgo setMotion: PolyPath 58 100 self)
				)
				(5
					(gEgo
						view: 8763
						setLoop: 0 1
						cel: 0
						setCycle: CT 7 1 self
					)
				)
				(6
					(gEgo put: 37 get: 38 setCycle: End self) ; Big_Gem, Hammer_and_Chisel
					(SetFlag 388)
					(self setScript: jewelerLeave self)
				)
				(7 0)
				(8
					(gEgo normalize: 3 setHeading: 180 self)
				)
				(9
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(jeweler dispose:)
			(SetFlag 388)
			(gEgo normalize: 3 put: 37 get: 38 setHeading: 180 self) ; Big_Gem, Hammer_and_Chisel
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance jewelerLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jeweler view: 20570 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(jeweler
					setLoop: 1 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 81 85 self
				)
			)
			(2
				(jeweler dispose:)
				(self dispose:)
			)
		)
	)
)

(instance putMoldInWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 (gEgo x:))
				(= local5 (gEgo y:))
				(= cycles 1)
			)
			(1
				(gEgo
					view: 2054
					loop: 1
					cel: 0
					x: 223
					y: 142
					priority: 143
					fixPriority: 1
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(gKqSound1 number: 2058 loop: 1 play:)
				(gEgo
					view: 2054
					loop: 2
					cel: 0
					x: 205
					y: 109
					setCycle: End self
				)
			)
			(3
				(SetFlag 72)
				(gEgo
					view: 2054
					loop: 3
					cel: 0
					x: 231
					y: 109
					priority: 143
					fixPriority: 1
					setScale: 0
					setCycle: CT 2 1 self
				)
			)
			(4
				(gKqSound1 number: 836 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo loop: 4 cel: 0 posn: 241 108 setCycle: End self)
			)
			(6
				(= cycles 2)
			)
			(7
				((ScriptID 13 0) clientCel: -2 hide_mouth: 0) ; aEgoTalker
				(gMessager say: 6 8 6 1 self) ; "Yes!"
				(gEgo get: 25) ; Silver_Spoon
			)
			(8
				(gEgo
					normalize: 4
					posn: 260 108
					setScaler: Scaler 100 76 136 101
					setMotion: MoveTo local4 local5 self
				)
			)
			(9
				(gEgo setHeading: 180 self)
			)
			(10
				(SetFlag 73)
				(gGame handsOn:)
				(= cycles 1)
			)
			(11
				(localproc_0 99)
				(self dispose:)
			)
		)
	)
)

(instance leaveToGreatHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 320 104 self)
			)
			(1
				(gEgo setPri: 91 setMotion: MoveTo 302 77 self)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 2450)
			)
		)
	)
)

(instance leaveToMineShaft of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0 (gEgo scaleX:))
				(= temp1 (gEgo scaleY:))
				(gEgo setPri: 79 setLoop: 3 1 setScale:)
				(gEgo
					signal: (| (gEgo signal:) $0001)
					scaleX: temp0
					scaleY: temp1
					setMotion: MoveTo 156 105 self
				)
			)
			(1
				(gCurRoom newRoom: 2000)
			)
		)
	)
)

(instance getTongs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8773 loop: 0 cel: 0 setCycle: CT 8 1 self)
			)
			(1
				(tongs hide:)
				(tongFeat init:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize: 3 setScaler: Scaler 100 76 136 101)
				(gGame handsOn:)
				(localproc_0 99)
				(tongs doVerb: 99)
				(self dispose:)
			)
		)
	)
)

(instance putTongs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8773 loop: 0 cel: 0 setCycle: CT 8 1 self)
			)
			(1
				(tongs verb: 99 posn: 209 52 init: setHotspot: 8 10) ; Do, Exit
				(if (IsFlag 72)
					(tongs setHotspot: 0)
				)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize: 3 setScaler: Scaler 100 76 136 101)
				(gGame handsOn:)
				(tongFeat doVerb: 8)
				(self dispose:)
			)
		)
	)
)

(instance shaftDoor of ExitFeature
	(properties
		nsLeft 117
		nsTop 27
		nsRight 160
		nsBottom 78
		approachX 139
		approachY 79
		x 139
		y 75
		exitDir 7
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: leaveToMineShaft)
		)
	)
)

(instance forgeDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 309
		approachY 103
		x 309
		y 100
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 303 95 296 75 297 55 304 37 308 31 314 31 320 35 320 102
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: leaveToGreatHall)
		)
	)
)

(instance tongFeat of Feature
	(properties
		nsLeft 203
		nsTop 38
		nsRight 215
		nsBottom 51
		approachX 195
		approachY 90
		x 210
		y 35
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 99 96 approachVerbs: 99 96) ; tongs, tongs with mold, tongs, tongs with mold
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 99 96) ; tongs, tongs with mold
			(gCurRoom setScript: putTongs)
		else
			(tongs verb: 99 posn: 209 52 init:)
			(self dispose:)
			(= global308 0)
			(gUser message: (gUser dftMessage:))
			(if (gUser canInput:)
				(gTheInvCursor view: 999 loop: 0 setCel: 0 init:)
			)
			(gGame setCursor: gNormalCursor 1)
			(if (IsFlag 72)
				(self setHotspot: 0)
				(tongs setHotspot: 0)
			else
				(tongs setHotspot: 8 10) ; Do, Exit
				(mold init:)
			)
		)
		(return 1)
	)
)

(instance tongs of useObj
	(properties
		noun 3
		approachX 224
		approachY 98
		x 209
		y 52
		view 2050
		loop 2
		verb 99
		myCursorView 991
		myCursorLoop 5
		myCursorCel 3
	)

	(method (init)
		(super init: &rest)
		(if
			(and
				(not (gEgo has: 25)) ; Silver_Spoon
				(not (IsFlag 55))
				(not (IsFlag 72))
			)
			(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (super onMe: param1))
		(if (and (param1 type:) (IsFlag 67))
			(= approachX 195)
			(= approachY 90)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 99) ; tongs
			(super doVerb: 8)
			(return 1)
		)
		(cond
			((IsFlag 67)
				(gCurRoom setScript: getTongs)
			)
			(local1
				(gCurRoom setScript: waveFinger)
			)
			(else
				(= local1 1)
				(gCurRoom setScript: kissAtRosella)
			)
		)
		(return 1)
	)
)

(instance waveFinger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(forgerPounds caller: self register: 1)
			)
			(2
				(forger
					setCycle: 0
					setScript: 0
					view: 2053
					loop: 3
					cel: 0
					x: 209
					y: 109
					setCycle: End self
				)
			)
			(3
				(forger setCycle: Beg self)
			)
			(4
				(forgerTalker clientCel: -2)
				(gMessager say: 3 8 3 0 self) ; "No you don't, you naughty goil!"
			)
			(5
				(forger setScript: forgerPounds)
				(= cycles 1)
			)
			(6
				(gEgo
					normalize:
					setScaler: Scaler 100 76 136 101
					setHeading: 180 self
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance kissAtRosella of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gMessager say: 3 8 1 1 self) ; "May I jsut borrow these tongs for a few minutes, sir?"
			)
			(2
				(forgerPounds caller: self register: 1)
			)
			(3
				(forger
					setCycle: 0
					setScript: 0
					view: 2053
					loop: 3
					cel: 0
					x: 209
					y: 109
				)
				(forgerTalker clientCel: -2)
				(= cycles 1)
			)
			(4
				(gMessager say: 3 8 1 2 self) ; "(FLIRTING)I just can't let you do dat, sugar lips. How about a smooch instead?"
			)
			(5
				(forger view: 2053 loop: 2 cel: 0 x: 215 y: 76 setCycle: Fwd)
				(gKqSound1 number: 2056 loop: 1 play: self)
			)
			(6
				(forger view: 2053 loop: 3 cel: 0 x: 209 y: 109 setCycle: 0)
				(= cycles 1)
			)
			(7
				(gMessager sayRange: 3 8 1 3 4 self) ; "No thanks!"
			)
			(8
				(forger setScript: forgerPounds)
				(= cycles 1)
			)
			(9
				(gEgo
					normalize:
					setScaler: Scaler 100 76 136 101
					setHeading: 180 self
				)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnAndKissAtRosella of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 (gEgo x:))
				(= local5 (gEgo y:))
				(forgerPounds caller: self next: forgerRests)
			)
			(1
				(gEgo hide:)
				(hammer
					view: 20513
					loop: 3
					cel: 0
					setPri: 150
					posn: 182 106
					init:
				)
				(forger view: 20525 setLoop: 3 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(gKqSound1 number: 2056 loop: 1 play: self)
			)
			(3
				(gKqSound1 number: 895 loop: 1 play:)
				(forger setCycle: End self)
			)
			(4
				(gEgo
					show:
					view: 20525
					setLoop: 4 1
					cel: 0
					setScale: 0
					posn: (forger x:) (forger y:)
					setCycle: End self
				)
				(hammer dispose:)
				(forger setScript: forgerReturnFromRest self)
			)
			(5 0)
			(6
				(gEgo
					normalize: 2
					posn: (forger approachX:) (forger approachY:)
					setScaler: Scaler 100 76 136 101
					setMotion: MoveTo local4 local5 self
				)
			)
			(7
				(gEgo setHeading: 180 self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moldyFeat of Feature
	(properties
		nsLeft 170
		nsTop 68
		nsRight 195
		nsBottom 100
		y 102
	)

	(method (init)
		(super init: &rest)
		(SetNowSeen mold)
		(= nsLeft (mold nsLeft:))
		(= nsTop (mold nsTop:))
		(= nsRight (mold nsRight:))
		(= nsBottom (mold nsBottom:))
		(self setHotspot: 0 96) ; tongs with mold
	)

	(method (doVerb)
		(localproc_0 99)
	)
)

(instance mold of View
	(properties
		noun 4
		approachX 153
		approachY 102
		x 180
		y 103
		z 30
		view 2050
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 98 setHotspot: 8 10 99 approachVerbs: 8) ; Do, Exit, tongs, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 67)
					(gMessager say: noun theVerb 5 1) ; "(THINKS TO HERSELF)That's way too hot to touch."
				else
					(gCurRoom setScript: tryToGetMold)
					(self setHotspot: 0)
				)
				(return 1)
			)
			(99 ; tongs
				(localproc_0 96)
				(self dispose:)
			)
		)
	)
)

(instance tryToGetMold of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 8 4 1 self) ; "What's that?"
			)
			(1
				(forgerPounds caller: self next: forgerRests)
			)
			(2
				(gMessager say: 4 8 4 2 self) ; "(CONDESCENDING)Dat, little goil, is a mold for casting tings. I poured hot silver in dere, see, and when it cools, I have a spoon!"
			)
			(3
				(forger setScript: forgerReturnFromRest self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bellows of Prop
	(properties
		approachX 224
		approachY 93
		x 253
		y 88
		priority 100
		fixPriority 1
		view 2050
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if
			(and
				(IsFlag 67)
				(not (IsFlag 55))
				(not local8)
				(not (IsFlag 60))
			)
			(self setHotspot: 8 10 43 approachVerbs: 8) ; Do, Exit, Lantern, Do
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: pumpBellows)
				(return 1)
			)
			(43 ; Lantern
				(if (gCast contains: sparks)
					(sparks doVerb: theVerb)
				)
			)
		)
	)
)

(instance workTable of Feature ; UNUSED
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 96 ; Do, tongs with mold
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 147 76 147 81 172 82 194 75 194 70 194 70 172 69
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(mold init:)
				(tongs verb: 99)
			)
		)
	)
)

(instance water of Feature
	(properties
		noun 6
		approachX 269
		approachY 108
		x 231
		y 122
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 96 ; Do, Exit, tongs with mold
			approachVerbs: 8 96 ; Do, tongs with mold
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 242 113 244 99 223 99 219 107 225 113
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(96 ; tongs with mold
				(gCurRoom setScript: putMoldInWater)
				(self dispose:)
			)
			(8 ; Do
				(gMessager say: noun theVerb 7 1) ; "(THINKS TO HERSELF)Yech. That's some nasty water."
			)
		)
	)
)

(instance oven of Prop
	(properties
		noun 2
		sightAngle 10
		approachX 231
		approachY 91
		approachDist 30
		x 271
		y 85
		view 2050
	)

	(method (init)
		(super init: &rest)
		(self setPri: 95 approachVerbs: 8 41) ; Do, Wet_Sulfur
		(if (or (not (IsFlag 386)) (not (IsFlag 387)))
			(self setHotspot: 9998)
		)
		(= local2
			(if (and (IsFlag 355) (not (IsFlag 67)))
				(not (IsFlag 55))
			)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if
			(or
				(and (== (gUser message:) 41) (not local2))
				(and
					(or (== (gUser message:) 44) (== (gUser message:) 43))
					(IsFlag 387)
				)
				(OneOf (gUser message:) 99 96)
			)
			(return 0)
		)
		(= temp0 (super onMe: param1))
		(cond
			((== (gUser message:) 43)
				(= approachX (gEgo x:))
				(= approachY (gEgo y:))
			)
			(
				(and
					(== (param1 message:) 8)
					(>= (gEgo x:) 230)
					(>= (gEgo y:) 105)
				)
				(= approachX 284)
				(= approachY 104)
			)
			(else
				(= approachX 231)
				(= approachY 91)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gKqSound1 number: 2059 loop: 1 play:)
				(gMessager say: noun theVerb 8 1) ; "(THINKS TO HERSELF)Wow. You could melt rocks in there."
				(return 1)
			)
			(43 ; Lantern
				(if (gCast contains: sparks)
					(sparks doVerb: theVerb)
				else
					(gMessager say: noun theVerb 2 1) ; "Oh, darn. I let it get too cold."
				)
				(return 1)
			)
			(41 ; Wet_Sulfur
				(if (and (not (IsFlag 67)) (not (IsFlag 55)) (IsFlag 355))
					(gEgo put: 34) ; Wet_Sulfur
					(gCurRoom setScript: throwSulfur)
					(return 1)
				)
				(return 0)
			)
			(else
				(gMessager say: noun 0 0 1) ; "(THINKS TO HERSELF)No. I might need that."
			)
		)
	)
)

(instance sparks of Prop
	(properties
		approachX 260
		approachY 112
		x 272
		y 82
		view 20511
	)

	(method (init)
		(super init: &rest)
		(self setPri: 96 setScript: sparksFly)
		(if (not (IsFlag 60))
			(self setHotspot: 8 10 43) ; Do, Exit, Lantern
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; Lantern
				(gCurRoom setScript: catchSpark)
				(return 1)
			)
		)
	)
)

(instance forger of Prop
	(properties
		noun 1
		sightAngle 10
		approachX 153
		approachY 102
		x 187
		y 108
		view 2051
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setPri: 109) ; Do
		(if (IsFlag 77)
			(self setHotspot: 8 10) ; Do, Exit
		)
		(if (and (IsFlag 67) (not (IsFlag 55)))
			(if (not (IsFlag 78))
				(self posn: 209 102)
			else
				(self posn: 191 110)
			)
			(self setPri: 98 setScript: snoreScript)
		else
			(self setScript: forgerPounds)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((IsFlag 55)
						(gCurRoom setScript: talkToForgerAsHuman)
					)
					((IsFlag 67)
						(gCurRoom setScript: kickForger)
						(self setHotspot: 0)
					)
					((not (SetFlag 365))
						(gCurRoom setScript: talkForgerFirst)
					)
					(else
						(gCurRoom setScript: turnAndKissAtRosella)
					)
				)
				(return 1)
			)
		)
	)
)

(instance talkToForgerAsHuman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(forgerPounds caller: self next: forgerRests)
			)
			(1
				(hammer
					view: 20513
					loop: 3
					cel: 0
					setPri: 150
					posn: 182 106
					init:
				)
				(cond
					((not (SetFlag 366))
						(gMessager say: 1 8 9 0 self) ; "Um, hello. How are you feeling?"
					)
					((not (SetFlag 367))
						(gMessager say: 1 8 10 0 self) ; "I know you can't stand it, babe, but you'll have to wait until I get off work."
					)
					(else
						(gMessager say: 1 8 11 0 self) ; "Patience, my little whey-face, patience!"
					)
				)
			)
			(2
				(hammer dispose:)
				(forger setScript: forgerReturnFromRest self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jeweler of Actor
	(properties
		noun 5
		approachX 66
		approachY 107
		x 43
		y 86
		view 20512
		cel 5
	)

	(method (init)
		(super init: &rest)
		(self
			setPri: 10
			setHotspot: 8 10 45 96 ; Do, Exit, Big_Gem, tongs with mold
			approachVerbs: 8 45 96 ; Do, Big_Gem, tongs with mold
			setScript: jewelerWork
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((not (IsFlag 58))
						(gCurRoom setScript: introduceToJeweler)
					)
					((gEgo has: 37) ; Big_Gem
						(gMessager say: noun theVerb 13 0) ; "Excuse me."
					)
					(else
						(gMessager say: noun theVerb 12 1) ; "(THINKS TO HERSELF)I should let the poor guy work. He's so jumpy!"
					)
				)
				(return 1)
			)
			(45 ; Big_Gem
				(if (IsFlag 58)
					(gCurRoom setScript: giveGem)
				else
					(gMessager say: noun theVerb 16 1) ; "(THINKS TO HERSELF)I don't even know that guy. He might try to take the gem away from me."
				)
				(return 1)
			)
			(96 ; tongs with mold
				(gCurRoom setScript: askAboutMold)
				(return 1)
			)
		)
	)
)

(instance bowl of View
	(properties
		x 248
		y 86
		z 16
		view 20521
		loop 1
	)
)

(instance hammer of View
	(properties
		x 170
		y 81
		priority 98
		fixPriority 1
		view 20521
		loop 2
	)
)

(instance smoke of Prop
	(properties
		x 237
		y 102
		priority 100
		fixPriority 1
		view 20550
		loop 4
	)

	(method (cue)
		(self dispose:)
	)
)

(instance anvilSound of Sound
	(properties)

	(method (init)
		(super init: &rest)
		(self flags: 4 owner: gCurRoom)
	)
)

(instance sparksSound of Sound
	(properties)

	(method (init)
		(super init: &rest)
		(self flags: 4 owner: gCurRoom)
	)
)

(instance jewelerSound of Sound
	(properties)

	(method (init)
		(super init: &rest)
		(self flags: 4 owner: gCurRoom)
	)
)

(instance snoreSound of Sound
	(properties)

	(method (init)
		(super init: &rest)
		(self flags: 4 owner: gCurRoom)
	)
)

(instance forgerTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(= client forger)
		(super init: &rest)
	)
)

(instance jewelerTalker of KQTalker
	(properties)

	(method (init)
		(= client jeweler)
		(super init: &rest)
	)
)

(instance roomFeatureInitCode of Code
	(properties)

	(method (doit param1)
		(if
			(and
				(not (param1 isKindOf: KQInventory))
				(param1 respondsTo: #signal)
			)
			(param1 sightAngle: 10 signal: (| (param1 signal:) $7001))
		)
	)
)

