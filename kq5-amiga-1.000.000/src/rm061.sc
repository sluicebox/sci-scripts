;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Interface)
(use castle)
(use DLetter)
(use KQ5Room)
(use Polygon)
(use RFeature)
(use Motion)
(use System)

(public
	rm061 0
)

(local
	[local0 30] = [319 189 0 189 0 0 137 0 171 124 168 130 131 131 116 142 36 142 16 168 39 168 14 186 300 186 281 173 319 173]
	[local30 14] = [319 163 262 163 228 151 203 126 179 126 157 0 319 0]
)

(instance rm061 of KQ5Room
	(properties
		picture 61
		north 62
		east 60
	)

	(method (init)
		(super init:)
		(= global345 240)
		(= global346 173)
		(= global355 44)
		(= global356 164)
		(= global357 247)
		(= global358 176)
		(= global347 51)
		(= global348 159)
		(self
			setFeatures: statue doorWay1 doorWay2 room
			setRegions: 550 ; castle
			addObstacle: poly1 poly2
		)
		(switch gPrevRoomNum
			(north
				(gCurRoom setScript: goDownstairs)
			)
			(else
				(gCurRoom setScript: enterRight)
			)
		)
		(if
			(and
				(IsFlag 104)
				(not global352)
				(not global353)
				(> (Random 0 100) 25)
			)
			(proc550_16)
		)
		(SetFlag 104)
		(poly1 points: @local0 size: 15)
		(poly2 points: @local30 size: 7)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (== global331 3) (gEgo inRect: 29 133 174 184))
				(if (Random 0 1)
					(= global349 46)
					(= global350 153)
					(= global351 135)
					(= global354 225)
				else
					(= global349 243)
					(= global350 157)
					(= global351 225)
					(= global354 135)
				)
				((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
			)
			((gEgo inRect: 283 162 312 173)
				(gCurRoom setScript: exitRight)
			)
			((& (gEgo onControl:) $4000)
				(gCurRoom setScript: goUpstairs)
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

(instance statue of RFeature
	(properties
		nsTop 4
		nsLeft 50
		nsBottom 136
		nsRight 121
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 61 0) ; "Graham gapes at an odd figure of a bird-like, yet reptilian woman."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 61 1) ; "Curiously, Graham looks at the strange figure. There is nothing of use here, though."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay1 of RFeature
	(properties
		nsTop 48
		nsLeft 266
		nsBottom 180
		nsRight 308
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 61 2) ; "Graham can see the huge dining hall through the doorway."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay2 of RFeature
	(properties
		nsTop 35
		nsLeft 153
		nsBottom 124
		nsRight 206
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 61 3) ; "Beyond an open doorway a set of stone steps lead upwards."
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
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 61 4) ; "Graham looks in astonishment around this strange foyer filled with an assortment of bizarre oddities."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance goDownstairs of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					init:
					illegalBits: 0
					ignoreActors: 1
					blocks: 0
					posn: 155 7
					setMotion: MoveTo 176 124 self
				)
			)
			(1
				(gEgo view: 0)
				(proc550_18)
				(if
					(and
						(> (Random 0 100) 50)
						(== global332 0)
						(not global352)
						(not global353)
					)
					((ScriptID 550 3) init:) ; theHenchMan
				)
				(client setScript: 0)
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
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 337 169 self
				)
			)
			(1
				(gCurRoom newRoom: 60)
			)
		)
	)
)

(instance enterRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(proc550_17)
				(gEgo
					init:
					illegalBits: 0
					blocks: 0
					ignoreActors: 1
					posn: 337 169
					setMotion: MoveTo 274 169 self
				)
			)
			(2
				(proc550_18)
				(if
					(and
						(> (Random 0 100) 50)
						(== global332 0)
						(not global352)
						(not global353)
					)
					((ScriptID 550 3) init:) ; theHenchMan
				)
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

(instance goUpstairs of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					ignoreHorizon: 1
					setMotion: MoveTo 173 107 self
				)
			)
			(1
				(if (!= global333 4)
					(if (< (gEgo distanceTo: (ScriptID 550 3)) 30) ; theHenchMan
						((ScriptID 550 3) setScript: 0 setMotion: 0) ; theHenchMan
					)
					(gEgo setMotion: MoveTo 155 7 self)
				else
					(client setScript: 0)
				)
			)
			(2
				(gCurRoom newRoom: 62)
			)
		)
	)
)

