;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Polygon)
(use RFeature)
(use Motion)
(use System)

(public
	rm029 0
)

(local
	local0
	local1
	[local2 32] = [0 162 146 119 223 79 232 60 196 58 192 58 119 55 112 51 117 47 229 38 252 41 286 32 273 0 319 0 319 189 0 189]
	[local34 30] = [0 0 257 0 273 31 189 28 181 35 120 39 99 51 107 62 189 62 190 69 144 81 149 88 121 103 57 119 0 127]
)

(instance rm029 of KQ5Room
	(properties
		picture 29
		north 30
		west 2
	)

	(method (init)
		(super init:)
		(= global320 119)
		(= global321 63)
		(= global325
			{"It's cold, Graham! Let's get moving!"}
		)
		(self setFeatures: path29 cliffs setRegions: 202) ; owl
		(switch gPrevRoomNum
			(west
				(gEgo view: 2 posn: 6 151)
				(= local0 1)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
				(gGlobalSound number: 5 loop: -1 play:)
			)
			(north
				(gEgo
					normal: 1
					view: (if (IsFlag 15) 14 else 108)
					posn: 261 35
				)
				(++ local1)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gGlobalSound number: 5 loop: -1 play:)
				(gEgo view: 2 posn: 6 151)
				(= local0 1)
			)
		)
		(gEgo setStep: 2 1 init:)
		(poly1 points: @local2 size: 16)
		(poly3 points: @local34 size: 15)
		(self addObstacle: poly1 poly3)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((not local1)
				(++ local1)
				(gEgo setScript: timedMess)
			)
			((& (gEgo onControl: 1) $0004)
				((ScriptID 202 2) register: 1) ; stdWalkOut
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
				(gGlobalSound fade:)
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
			)
			(
				(and
					(not (IsFlag 15))
					(not (== (gEgo view:) 106))
					(not (== (gEgo view:) 108))
					(> (gEgo x:) 20)
				)
				(PrintDC 29 0) ; "Graham begins to shiver at the sudden drop in temperature."
				((gEgo head:) hide:)
				(gEgo view: 106)
			)
			((& (gEgo onControl: 0) $2000)
				(proc0_28 75 29 1 67 10 10 25 5) ; "No! Stay away from the edge...!"
				(self setScript: falling)
			)
			((& (gEgo onControl: 1) $1000)
				(if (IsFlag 15)
					(gEgo view: 14)
					((gEgo head:) show:)
				else
					(gEgo view: 108)
					((gEgo head:) hide:)
				)
			)
			((& (gEgo onControl: 1) $4000)
				(gEgo normal: 1)
				(if (IsFlag 15)
					(gEgo view: 12)
				else
					(gEgo view: 106)
				)
				((gEgo head:) show:)
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
			(else
				(switch (event message:)
					(4 ; Inventory
						(if (MousedOn gEgo event)
							(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
								(26
									(if (not (IsFlag 15))
										(if (not (IsFlag 48))
											(SetFlag 48)
											(SetScore 4)
										)
										(gGlobalSound2 fade:)
										(SetFlag 15)
										(PrintDC 29 2) ; "Graham dons his cloak for warmth in the snowy mountains."
										(gEgo
											view:
												(if (== (gEgo view:) 108)
													14
												else
													12
												)
										)
										((gEgo head:) show:)
										(event claimed: 1)
									)
								)
								(28
									(event claimed: 0)
								)
								(else
									(if (not (IsFlag 15))
										(PrintDC 29 3) ; "Graham needs warmth, not this!"
										(event claimed: 1)
									)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance timedMess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_15 (Format @global185 29 4)) ; "A few hours later....."
				(= seconds 30)
			)
			(1
				(proc0_15 0)
				(client setScript: 0)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view:
						(cond
							((== (gEgo view:) 2)
								(if (IsFlag 15) 78 else 70)
							)
							((IsFlag 15) 80)
							(else 72)
						)
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
					setPri:
						(if (< (gEgo y:) 100)
							1
						else
							(gEgo priority:)
						)
					illegalBits: 0
				)
				(gGlobalSound3 number: 83 loop: 1 vol: 127 priority: 15 play:)
			)
			(1
				(gEgo
					yStep: 8
					setMotion: MoveTo (- (gEgo x:) 20) 230 self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(= global330
					{That last step was a doozy!}
				)
				(EgoDead)
			)
		)
	)
)

(instance path29 of RFeature
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
					(PrintDC 29 5) ; "An icy, treacherous path skirts the snowy mountainside as it winds its way ever upward."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cliffs of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 29 6) ; "Sheer, vertical cliffs plummet dizzyingly downward from the edge of the frozen path."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

