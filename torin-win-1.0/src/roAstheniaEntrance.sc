;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40100)
(include sci.sh)
(use Main)
(use oBoogle)
(use oHandsOnWhenCued)
(use TPScript)
(use n64896)
(use foEExit)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roAstheniaEntrance 0
)

(instance foExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
		(self setRect: 475 76 583 181)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 130) ; oFlags
			(gEgo setScript: soExit)
		else
			(gEgo setScript: soCheckExit)
		)
	)
)

(instance soCheckExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 530 175 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 450 160 self)
			)
			(2
				(gMessager say: 0 0 3 0 self) ; "There's a door back here, but it won't open. And there's no knob!"
			)
			(3
				(gEgo setMotion: MoveTo 530 175 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 530 175 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleExit) ; oBoogle
				(gEgo setMotion: MoveTo 450 160 self)
			)
			(2
				((ScriptID 64018 0) setScript: 0) ; oBoogle
				(gCurRoom newRoom: 40200) ; roAstheniaIsland
			)
		)
	)
)

(instance soBoogleExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					setMotion: PolyPath 570 175 self
				)
			)
			(1
				((ScriptID 64018 0) setMotion: MoveTo 450 160 self) ; oBoogle
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance foPhenocryst of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= noun 2)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 47 82 58 39 78 4 99 17 122 73 127 105 122 146 98 201 79 178 65 178 66 157 85 94 64 85
					yourself:
				)
		)
		(self addHotspotVerb: 1 13)
	)
)

(instance poLava1 of Prop
	(properties
		x 603
		y 108
		priority 500
		fixPriority 1
		view 40203
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd self)
	)
)

(instance poLava2 of Prop
	(properties
		x 33
		y 91
		priority 500
		fixPriority 1
		view 40203
		loop 1
		cycleSpeed 9
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd self)
	)
)

(instance poLava3 of Prop
	(properties
		x 167
		y 75
		priority 236
		fixPriority 1
		view 40203
		loop 2
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd self)
	)
)

(instance poLava4 of Prop
	(properties
		x 291
		y 101
		priority 10
		fixPriority 1
		view 40203
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd self)
	)
)

(instance voDirtyTop of View
	(properties
		x 383
		y 239
		priority 306
		fixPriority 1
		view 40101
		loop 7
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
		(self addHotspotVerb: 1 49)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTryToRead)
			)
			(49 ; ioOpenAmmonia
				(gEgo setScript: soCleanConsole)
			)
		)
	)
)

(instance voConsoleDoor of View
	(properties
		x 297
		y 313
		priority 300
		fixPriority 1
		view 40101
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 354 235 377 254 377 308 354 285
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 128) ; oFlags
			(gEgo setScript: soTakeAmmonia)
		else
			(gEgo setScript: soOpenConsoleDoor)
		)
	)
)

(instance foButton of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 362 209 385 217)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soHitButton)
	)
)

(instance voLight of View
	(properties
		x 477
		y 130
		priority 1
		fixPriority 1
		useInsetRect 1
		view 40102
	)

	(method (init)
		(super init: &rest)
		(= useInsetRect 1)
		(= inRight (- (CelWide 40102 0 0) 1))
		(= inBottom (- (CelHigh 40102 0 0) 1))
		(UpdateScreenItem self)
	)
)

(instance soBoogleOutOfTheWay of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 308 270 self)
			)
			(1
				((ScriptID 64018 0) setHeading: 135 self) ; oBoogle
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soHitButton of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 304 314 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleOutOfTheWay) ; oBoogle
				(goSound1 preload: 40104)
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 40101
					loop: 6
					cel: 0
					posn: 304 314
					init:
					setCycle: CT 4 1 self
				)
			)
			(3
				(gCurRoom setScript: soOpenDoor self)
				(poTorin setCycle: End self)
			)
			(4
				(gEgo show:)
				(poTorin dispose:)
				(foButton dispose:)
				((ScriptID 64017 0) set: 130) ; oFlags
			)
			(5
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTryToRead of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 318 308 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleOutOfTheWay) ; oBoogle
				(gEgo setHeading: 90 self)
			)
			(2
				(gMessager say: 3 1 2 0 self) ; "Is that writing? It's so dirty I just can't tell."
			)
			(3
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCleanConsole of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 318 308 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 40105)
				((ScriptID 64018 0) setScript: soBoogleOutOfTheWay) ; oBoogle
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 40101
					loop: 4
					cel: 0
					posn: 314 307
					init:
					setCycle: CT 29 1 self
				)
			)
			(3
				(goSound1 playSound: 40105)
				(voDirtyTop hide:)
				(poTorin setCycle: End self)
			)
			(4
				(poTorin loop: 5 cel: 0 setCycle: End self)
				(voDirtyTop loop: 8 deleteHotspotVerb: 1 49 show:)
			)
			(5
				(gEgo posn: 316 306 loop: 2 heading: 180 stopwalk: show:)
				(poTorin dispose:)
				(foButton init:)
				((ScriptID 64017 0) set: 129) ; oFlags
				(gEgo get: ((ScriptID 64001 0) get: 36)) ; oInvHandler, ioOpenAmmonia
				(gEgo setHeading: 90 self)
			)
			(6
				(gMessager say: 3 49 2 0 self) ; "(READING CONSOLE AFTER CLEANING IT) "Welcome to Asthenia." Huh."
			)
			(7
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeAmmonia of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 296 313 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleOutOfTheWay) ; oBoogle
				(goSound1 preload: 40103)
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo hide:)
				(voConsoleDoor hide: loop: 0 posn: 297 313)
				(poTorin
					view: 40101
					loop: 3
					cel: 0
					posn: 296 312
					init:
					setCycle: CT 27 1 self
				)
			)
			(3
				(goSound1 playSound: 40103)
				(poTorin setCycle: End self)
			)
			(4
				(gEgo get: ((ScriptID 64001 0) get: 35)) ; oInvHandler, ioAmmonia
				((ScriptID 64017 0) set: 126) ; oFlags
				(gEgo show:)
				(poTorin dispose:)
				(voConsoleDoor deleteHotspotVerb: 1 show:)
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOpenConsoleDoor of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 295 307 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleOutOfTheWay) ; oBoogle
				(goSound1 preload: 40102)
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo hide:)
				(voConsoleDoor hide:)
				(poTorin
					view: 40101
					loop: 2
					cel: 0
					posn: 294 313
					init:
					setCycle: CT 3 1 self
				)
			)
			(3
				(goSound1 playSound: 40102)
				(poTorin setCycle: End self)
			)
			(4
				(poTorin dispose:)
				(voConsoleDoor loop: 1 cel: 0 posn: 295 307 show:)
				(gEgo show:)
				((ScriptID 64017 0) set: 128) ; oFlags
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOpenDoor of TPScript
	(properties)

	(method (changeState newState &tmp nWidth)
		(switch (= state newState)
			(0
				(goSound1 playSound: 40104)
				(= ticks 60)
			)
			(1
				(= ticks 6)
			)
			(2
				(= nWidth (+ (- (voLight inRight:) (voLight inLeft:)) 1))
				(= nWidth (Max 0 (- nWidth 2)))
				(voLight inLeft: (+ (- (voLight inRight:) nWidth) 1))
				(if (== nWidth 0)
					(self cue:)
				else
					(self changeState: 1)
				)
			)
			(3
				(voLight dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soEnterRoom of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(FadeToBlack 0 10 self)
			)
			(1
				(= ticks 240)
			)
			(2
				(Load rsVIEW 40100)
				(goSound1 playSound: 40101)
				(= ticks 1)
			)
			(3
				(= ticks 20)
			)
			(4
				(poTorin
					view: 40100
					loop: 0
					cel: 0
					posn: 254 269
					init:
					setCycle: CT 23 1 self
				)
			)
			(5
				(gMessager say: 0 0 1 0 self) ; "Wha!? Hey, I'm gettin' better at this!"
				(poTorin setCycle: CT 25 1 self)
			)
			(6)
			(7
				(poTorin setCycle: End self)
			)
			(8
				(poTorin dispose:)
				(gEgo
					normalize:
					posn: 254 269
					setLoop: 4
					heading: 135
					init:
					setScaler: Scaler 100 80 270 158
					doit:
				)
				(self setScript: (ScriptID 64018 2) self) ; soBoogleOutOfPouch
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roAstheniaEntrance of TPRoom
	(properties
		picture 40100
	)

	(method (init)
		(Palette 1 40000) ; PalLoad
		(super init: &rest)
		(goMusic1 setMusic: 40100)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 308 313 345 312 313 275 455 268 482 268 562 268 571 245 572 167 489 158 494 180 456 189 296 207 265 188 226 213 251 234 149 257 203 304
					yourself:
				)
		)
		(voDirtyTop init:)
		(voConsoleDoor init:)
		(foPhenocryst init:)
		(foExit init:)
		(voLight init:)
		(poLava1 init:)
		(poLava2 init:)
		(poLava3 init:)
		(poLava4 init:)
		((ScriptID 64018 0) ; oBoogle
			posn: 274 269
			init:
			normalize:
			setScaler: Scaler 100 80 270 158
			hide:
		)
		(gCurRoom setScript: soEnterRoom)
	)
)

