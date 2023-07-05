;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use Interface)
(use castle)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm059 0
)

(local
	[local0 8] = [0 173 19 173 5 189 0 189]
	[local8 30] = [0 0 319 0 319 189 309 189 309 181 289 161 268 157 243 163 227 156 94 156 68 162 52 157 38 158 31 165 0 165]
)

(instance rm059 of Rm
	(properties
		picture 59
		south 60
		west 58
	)

	(method (init)
		(super init:)
		(= global357 285)
		(= global358 174)
		(= global355 68)
		(= global356 171)
		(= global347 296)
		(= global348 172)
		(Load rsVIEW 896)
		(self
			setFeatures: firePlace birdMan1 birdMan2 table doorWay room
			setRegions: 550 ; castle
			addObstacle: poly1 poly2
		)
		(switch gPrevRoomNum
			(south
				(cond
					((< (gEgo x:) 150)
						(gEgo x: 67)
					)
					((> (gEgo x:) 255)
						(gEgo x: 292)
					)
					((> (gEgo x:) 220)
						(gEgo x: 256)
					)
					(else
						(gEgo x: 155)
					)
				)
				(gCurRoom setScript: enterBottom)
			)
			(else
				(gCurRoom setScript: enterLeft)
			)
		)
		(gEgo init: offset: 3)
		(if (and (== gPrevRoomNum 60) (== global333 3))
			(= global333 5)
		)
		(cond
			((== global333 5)
				(Load rsVIEW 896)
				(Load rsVIEW 904)
				(Load rsSOUND 18)
				(Load rsSOUND 71)
				(Load rsSOUND 135)
				(gCurRoom setScript: caughtScript)
			)
			((== global333 8)
				((ScriptID 550 3) ; theHenchMan
					init:
					posn: global364 global365
					setScript: 0
					view: 894
					setLoop: 2
					setCel: 255
					show:
					addToPic:
				)
			)
			((and (not global352) (not global353) (> (Random 0 100) 25))
				((ScriptID 550 3) init:) ; theHenchMan
			)
		)
		(poly1 points: @local0 size: 4)
		(poly2 points: @local8 size: 15)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo inRect: 97 158 224 187)
					(== global331 3)
					(not ((ScriptID 550 7) script:)) ; theWizard
				)
				(if (Random 0 1)
					(= global349 43)
					(= global350 168)
					(= global351 135)
					(= global354 225)
				else
					(= global349 288)
					(= global350 169)
					(= global351 225)
					(= global354 135)
				)
				((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
			)
			((gEgo inRect: -10 160 12 173)
				(gCurRoom setScript: exitLeft)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom setScript: exitDown)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance firePlace of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 59 0) ; "A massive dining table has been placed before a large, ornate fireplace."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 59 1) ; "Graham doesn't see anything interesting with the fireplace."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay of RFeature
	(properties
		nsTop 40
		nsLeft 5
		nsBottom 170
		nsRight 27
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 59 2) ; "The doorway goes into a hallway containing an unusual pipe organ."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance birdMan1 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 59 3) ; "Statues of weird "birdmen" line the walls of the immense dining hall."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 59 4) ; "Graham carefully examines the strange statues but sees nothing of use."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance birdMan2 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 59 3) ; "Statues of weird "birdmen" line the walls of the immense dining hall."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 59 4) ; "Graham carefully examines the strange statues but sees nothing of use."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 59 5) ; "This appears to be the huge dining hall of the castle. Graham wonders who eats here besides Mordack."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance table of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 59 0) ; "A massive dining table has been placed before a large, ornate fireplace."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 59 6) ; "Graham isn't interested in sitting around right now."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance exitLeft of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo -10 168 self
				)
			)
			(1
				(if
					(or
						(> (gEgo distanceTo: (ScriptID 550 3)) 50) ; theHenchMan
						(< global333 3)
						(== global333 8)
					)
					(= global333 0)
					(gCurRoom newRoom: 58)
				)
			)
		)
	)
)

(instance enterLeft of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					illegalBits: 0
					posn: -17 170
					setMotion: MoveTo 20 170 self
				)
			)
			(1
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

(instance enterBottom of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					illegalBits: 0
					posn: (gEgo x:) 249
					setMotion: MoveTo (gEgo x:) 188 self
				)
			)
			(1
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= global333 4)
				(proc550_17)
				(gEgo normal: 0 hide:)
				((gEgo head:) hide:)
				((ScriptID 550 3) ; theHenchMan
					init:
					setScript: 0
					show:
					posn: (gEgo x:) (gEgo y:)
					view: 896
					setLoop: -1
					setCycle: Walk
					setStep: 4 2
					cycleSpeed: 0
					illegalBits: 0
					ignoreActors: 1
					moveSpeed: 1
					setMotion: MoveTo global347 global348 self
				)
				(gGlobalSound number: 135 loop: -1 playBed:)
				((ScriptID 550 4) ; theMagicDoor
					init:
					show:
					setPri: 4
					posn: 310 179
					setLoop: 1
					cycleSpeed: 1
					setCycle: End
				)
				((ScriptID 550 5) ; theRings
					init:
					setLoop: 1
					setPri: 5
					posn: 310 131
					hide:
				)
				(gGlobalSound3 number: 18 loop: 1 play:)
			)
			(1
				((ScriptID 550 3) ; theHenchMan
					view: 904
					setLoop: 1
					cel: 0
					cycleSpeed: 3
					setPri: 8
					setCycle: End self
				)
				((ScriptID 550 5) show: cycleSpeed: 1 setScript: ringsScript) ; theRings
			)
			(2
				(gGlobalSound fade:)
				(= global333 4)
				((ScriptID 550 3) hide:) ; theHenchMan
				((ScriptID 550 5) hide:) ; theRings
				((ScriptID 550 4) setCel: 255 cycleSpeed: 2 setCycle: Beg self) ; theMagicDoor
				(gGlobalSound3 number: 18 loop: 1 play:)
			)
			(3
				(gGlobalSound3 stop:)
				((ScriptID 550 4) hide:) ; theMagicDoor
				(gCurRoom newRoom: 67)
			)
		)
	)
)

(instance blockOne of Blk ; UNUSED
	(properties
		top 1000
		left -1000
		bottom 1002
		right -1002
	)
)

(instance exitDown of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(if (and (== global333 3) (> ((ScriptID 550 3) y:) 200)) ; theHenchMan
					(= global333 6)
				)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 239 self
				)
			)
			(1
				(cond
					((< (gEgo x:) 113)
						(gEgo x: 119)
					)
					((> (gEgo x:) 220)
						(gEgo x: 243)
					)
					(else
						(gEgo x: 190)
					)
				)
				(if (!= global333 4)
					(if (!= global333 8)
						(= global333 0)
					)
					(gCurRoom newRoom: 60)
				)
			)
		)
	)
)

(instance ringsScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (< (DoSound sndGET_POLYPHONY) 8)
					((ScriptID 550 5) setCycle: End self) ; theRings
				else
					(gGlobalSound3 number: 71 loop: 1 play: self)
					((ScriptID 550 5) setCycle: End) ; theRings
				)
			)
			(1
				(= cycles 5)
			)
			(2
				(self init:)
			)
		)
	)
)

