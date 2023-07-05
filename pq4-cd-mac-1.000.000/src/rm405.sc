;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	rm405 0
)

(local
	local0
)

(instance rm405 of Room
	(properties
		noun 1
		picture 405
	)

	(method (doRemap)
		(gGame doRemap: 2 243 90)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(gGame handsOff:)
		(proc0_4 0)
		(if (!= gPrevRoomNum 410)
			(gGlobalSound1 number: 520 loop: -1 play: setVol: 95)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 186 119 124 119 98 150 31 150 31 153 210 153
					yourself:
				)
		)
		(door init: approachVerbs: 4) ; Do
		(desk init:)
		(switch gPrevRoomNum
			(410
				(recept init: signal: (| (recept signal:) $4000))
				(gEgo
					setHeading: 180
					normalize: 9120
					posn: 156 124 0
					setScaler: Scaler 100 65 148 117
					init:
				)
				(gGame handsOn:)
			)
			(else
				(gEgo
					normalize: 9120
					posn: 20 152 0
					setScaler: Scaler 100 65 148 117
					init:
				)
				(self setScript: enterScript)
				(if (not (gEgo has: 22)) ; folders
					(recept init: signal: (| (recept signal:) $4000))
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< (gEgo x:) 64) (not script))
			(gCurRoom newRoom: 17) ; MapRoom
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 410)
			(gGlobalSound1 fade: 0 10 10 1)
		)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(gCurRoom newRoom: 410)
	)
)

(instance recept of View
	(properties
		noun 2
		x 142
		y 81
		view 405
	)
)

(instance desk of Feature
	(properties
		noun 4
		nsLeft 124
		nsTop 79
		nsRight 181
		nsBottom 106
		x 155
		y 106
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not (gCast contains: recept))
				(gMessager say: noun theVerb 4) ; "Currently, no one occupies the reception area."
			else
				(gMessager say: noun theVerb 0) ; "Reception area for LA County Social Services."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance door of Feature
	(properties
		noun 3
		nsLeft 118
		nsTop 28
		nsRight 192
		nsBottom 116
		approachX 156
		approachY 124
		x 155
		y 80
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if (not (gCast contains: recept))
					(gMessager say: noun theVerb 1 0) ; "The door is locked."
				else
					(gMessager say: noun theVerb 0 0 gCurRoom) ; "You open the door to Social Services."
				)
			)
			((== theVerb 1) ; Look
				(if (not (gCast contains: recept))
					(gMessager say: noun theVerb 1) ; "No one appears behind the desk, maybe the office is closed."
				else
					(gMessager say: noun theVerb 0) ; "Double doors leading to the LA County Social Services office."
				)
			)
			((== theVerb 2) ; Talk
				(if (not (gCast contains: recept))
					(gMessager say: noun theVerb 1) ; "If you want to talk to someone, better open the door and go in."
				else
					(gMessager say: noun theVerb 0) ; "If you want to talk to someone, better open the door and go in."
				)
			)
			((== theVerb 46) ; keys
				(if (not (gCast contains: recept))
					(gMessager say: noun theVerb 1 0) ; "These are your personal keys. They won't unlock a County facility."
				else
					(gMessager say: noun theVerb 0 0) ; "You don't have keys to a County facility, besides, it's open."
				)
			)
			((== theVerb 22) ; handgun
				(cond
					((gCast contains: recept)
						(gMessager say: noun theVerb 0) ; "There is no tactical justification for your action. Secure your gun."
					)
					((not local0)
						(gMessager say: noun theVerb 2 0) ; "Holster your gun, the situation does not call for deadly use of force."
						(++ local0)
					)
					(((ScriptID 32 0) doit: noun theVerb 3 0 405) 0) ; ShootHandgun
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 153 (gEgo y:) self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

