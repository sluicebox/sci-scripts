;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Interface)
(use castle)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use System)

(public
	rm060 0
)

(local
	local0
	[local1 26] = [0 160 16 160 8 187 259 187 307 170 297 167 285 159 295 153 279 134 277 0 319 0 319 189 0 189]
	[local27 18] = [0 155 37 158 57 150 74 150 79 143 70 141 81 137 81 0 0 0]
)

(instance rm060 of Rm
	(properties
		picture 60
		horizon 140
		north 59
		west 61
	)

	(method (init)
		(super init:)
		(= global357 228)
		(= global358 152)
		(= global355 58)
		(= global356 167)
		(= global345 29)
		(= global346 160)
		(= global347 231)
		(= global348 145)
		(self
			setFeatures: firePlace doorWay1 doorWay2 birdMen room
			setRegions: 550 ; castle
			addObstacle: poly1 poly2
		)
		(switch gPrevRoomNum
			(north
				(gCurRoom setScript: enterNorth)
			)
			(else
				(gCurRoom setScript: enterLeft)
			)
		)
		(poly1 points: @local1 size: 13)
		(poly2 points: @local27 size: 9)
	)

	(method (doit &tmp temp0 temp1 [temp2 2])
		(= temp1 (gEgo y:))
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(not (gCurRoom script:))
					(gEgo inRect: 116 151 237 181)
					(== global331 3)
				)
				(if (Random 0 1)
					(= global349 99)
					(= global350 146)
					(= global351 135)
					(= global354 225)
				else
					(= global349 273)
					(= global350 151)
					(= global351 225)
					(= global354 135)
				)
				((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
			)
			((gEgo inRect: 0 153 13 165)
				(gCurRoom setScript: exitLeft)
			)
			((== 59 (self edgeToRoom: (gEgo edgeHit:)))
				(if
					(and
						(> ((ScriptID 550 3) x:) 0) ; theHenchMan
						(< (gEgo distanceTo: (ScriptID 550 3)) 90) ; theHenchMan
						(== global333 3)
					)
					(= global333 5)
				)
				(if (== global333 4)
					(= global333 5)
				)
				(gCurRoom newRoom: 59)
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
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 60 0) ; "A huge dining table, placed before an ornate fireplace, dominates the cavernous dining hall."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay1 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 60 1) ; "Through the doorway Graham can see a small downstairs foyer."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay2 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $4000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 60 2) ; "This doorway leads into an unusual downstairs hallway."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance birdMen of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 60 3) ; "Four curious statues representing strange "birdmen" line two walls of the dining hall."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 60 4) ; "Graham carefully examines the strange statues but sees nothing of use."
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
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 60 5) ; "Graham finds himself in Mordack's immense dining hall."
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
					setMotion: MoveTo -19 159 self
				)
			)
			(1
				(if (!= global333 4)
					(= global333 0)
					(gCurRoom newRoom: 61)
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
					init:
					offset: 3
					illegalBits: 0
					posn: -19 159
					setMotion: MoveTo 35 159 self
				)
				(if (and (not global352) (not global353))
					(if (> (Random 0 100) 50)
						((ScriptID 550 3) init:) ; theHenchMan
					else
						(proc550_16)
					)
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

(instance enterNorth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(if (== global333 6)
					(self changeState: 90)
				else
					(if (and (not global352) (not global353))
						(if (> (Random 0 100) 25)
							((ScriptID 550 3) init:) ; theHenchMan
						else
							(proc550_16)
						)
					)
					(if (== global333 8)
						((ScriptID 550 3) ; theHenchMan
							init:
							setScript: 0
							view: 894
							setLoop: 4
							posn: 175 134
							show:
							addToPic:
						)
					)
					(gEgo
						init:
						offset: 3
						posn: (gEgo x:) 141
						setMotion: MoveTo (gEgo x:) 151 self
					)
				)
			)
			(1
				(proc550_18)
				(client setScript: 0)
			)
			(90
				(gEgo init: hide: normal: 0)
				((gEgo head:) hide:)
				((ScriptID 550 3) ; theHenchMan
					init:
					show:
					setScript: 0
					view: 888
					setLoop: 2
					cel: 1
					posn: (gEgo x:) 160
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(91
				((ScriptID 550 3) ; theHenchMan
					view: 896
					setLoop: 3
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) global348 self
				)
			)
			(92
				(= global333 5)
				(gCurRoom newRoom: 59)
			)
		)
	)
)

