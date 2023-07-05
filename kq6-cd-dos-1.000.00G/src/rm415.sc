;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 415)
(include sci.sh)
(use Main)
(use rLab)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm415 0
)

(instance rm415 of LabRoom
	(properties
		south 400
	)

	(method (init)
		(if (== ((gInventory at: 11) owner:) gCurRoomNum) ; skull
			(theSkull init: stopUpd:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 0 319 0 319 189 190 189 190 185 276 185 264 172 261 178 237 178 198 155 206 152 240 151 205 151 190 143 117 143 117 153 90 164 72 157 38 185 130 185 130 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 196 152 180 152 176 149 181 146 195 146 200 149
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 0 319 0 319 189 190 189 190 185 276 185 264 172 261 178 237 178 198 155 206 152 240 151 205 151 190 143 117 143 117 153 90 164 72 157 38 185 130 185 130 189
						yourself:
					)
			)
		)
		(skelton1 init: stopUpd:)
		(skelton2 init: stopUpd:)
		(skelton3 init: stopUpd:)
		(super init: &rest)
		(gCurRoom setScript: (ScriptID 30 1)) ; walkIn
		((ScriptID 30 0) initCrypt: 1) ; rLab
	)

	(method (notify)
		((ScriptID 30 3) show:) ; theTorch
	)
)

(instance theSkull of View
	(properties
		x 189
		y 151
		noun 12
		modNum 400
		view 403
		loop 6
		cel 3
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getSkull)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skelton1 of View
	(properties
		x 87
		y 138
		noun 10
		modNum 400
		view 403
		loop 6
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 0)
			(gMessager say: 10 5 0 1) ; MISSING MESSAGE
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance skelton2 of View
	(properties
		x 239
		y 163
		noun 10
		modNum 400
		view 403
		loop 6
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 0)
			(gMessager say: 10 5 0 1) ; MISSING MESSAGE
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance skelton3 of View
	(properties
		x 227
		y 143
		noun 10
		modNum 400
		view 403
		loop 6
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 0)
			(gMessager say: 10 5 0 1) ; MISSING MESSAGE
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance getSkull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 204 151 self)
			)
			(1
				(gEgo setHeading: 270)
				(= cycles 8)
			)
			(2
				(gEgo
					normal: 0
					view: 401
					setLoop: 1
					cycleSpeed: 6
					posn: 193 153
					setCycle: CT 3 1 self
				)
			)
			(3
				(gMessager say: 12 5 0 1 self 400) ; "Alexander picks up the skull."
			)
			(4
				(gGame givePoints: 1)
				(theSkull dispose:)
				(gEgo setCycle: End self)
			)
			(5
				((gCurRoom obstacles:) dispose:)
				(gGame handsOn:)
				(gEgo posn: 204 151 get: 11 reset: 1) ; skull
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 189 0 0 319 0 319 189 190 189 190 185 276 185 264 172 261 178 237 178 198 155 206 152 240 151 205 151 190 143 117 143 117 153 90 164 72 157 38 185 130 185 130 189
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

