;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
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
	rm062 0
)

(local
	[local0 12] = [253 189 253 173 35 173 51 142 0 143 0 189]
	[local12 8] = [319 150 267 150 277 189 319 189]
	[local20 32] = [0 127 52 127 52 119 68 116 80 104 119 104 131 119 184 119 196 102 233 102 246 117 261 119 266 127 319 126 319 0 0 0]
)

(instance rm062 of Rm
	(properties
		picture 62
		east 65
		south 61
		west 63
	)

	(method (init)
		(super init:)
		(= global333 0)
		(Load rsVIEW 34)
		(self
			setFeatures: stairs skull doorWay1 doorWay2 windows
			setRegions: 550 ; castle
			addObstacle: poly1 poly2 poly3
		)
		(switch gPrevRoomNum
			(south
				(gCurRoom setScript: goUpstairs)
			)
			(east
				(gCurRoom setScript: enterRight)
			)
			(else
				(gCurRoom setScript: enterLeft)
			)
		)
		(glow1 cycleSpeed: 4 setCycle: (if (> global81 1) Fwd else 0) init:)
		(gEgo init: offset: 3)
		(poly1 points: @local0 size: 6)
		(poly2 points: @local12 size: 4)
		(poly3 points: @local20 size: 16)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(not (gCurRoom script:))
					(gEgo inRect: 109 128 207 159)
					(== global331 3)
				)
				(if (Random 0 1)
					(= global349 45)
					(= global350 129)
					(= global351 270)
					(= global354 90)
				else
					(= global349 245)
					(= global350 125)
					(= global351 90)
					(= global354 270)
				)
				((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
			)
			((gEgo inRect: -4 127 34 145)
				(gCurRoom setScript: exitLeft)
			)
			((gEgo inRect: 278 126 322 145)
				(gCurRoom setScript: exitRight)
			)
			((& (gEgo onControl:) $4000)
				(gCurRoom setScript: goDownstairs)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
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

(instance glow1 of Prop
	(properties
		y 83
		x 158
		view 700
	)
)

(instance skull of RFeature
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
					(PrintDC 62 0) ; "A huge monstrosity of a skull-like figure leers over passersby of an upstairs hallway."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 62 1) ; "Graham looks up at the leering figure but sees nothing of any of use."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance windows of RFeature
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
					(PrintDC 62 2) ; "Graham looks out the spiked windows and views the distorted rocks and twisted forms of Mordack's strange island."
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
					(PrintDC 62 3) ; "This doorway leads into Mordack's bedroom."
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
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 62 4) ; "Graham can see a bit of Mordack's laboratory through the doorway."
					(event claimed: 1)
				)
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

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance goDownstairs of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					blocks: 0
					setMotion: MoveTo 271 255 self
				)
			)
			(1
				(gCurRoom newRoom: 61)
			)
		)
	)
)

(instance goUpstairs of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					init:
					view: 34
					illegalBits: 0
					posn: 271 255
					setMotion: MoveTo 262 175 self
				)
			)
			(1
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

(instance enterRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					init:
					view: 34
					posn: 358 139
					setMotion: MoveTo 276 139 self
				)
			)
			(1
				(proc550_18)
				(client setScript: 0)
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
					view: 34
					posn: -2 139
					setMotion: MoveTo 43 139 self
				)
			)
			(1
				(proc550_18)
				(= global359 0)
				(client setScript: 0)
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
				(gEgo setMotion: MoveTo -2 139 self)
			)
			(1
				(gCurRoom newRoom: 63)
			)
		)
	)
)

(instance exitRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo setMotion: MoveTo 358 139 self)
			)
			(1
				(gGlobalSound fade:)
				(gCurRoom newRoom: 65)
			)
		)
	)
)

(instance stairs of RFeature
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
					(PrintDC 62 5) ; "The stairway leads down to a lower-level foyer."
					(event claimed: 1)
				)
			)
		)
	)
)

