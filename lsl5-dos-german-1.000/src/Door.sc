;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use PolyPath)
(use Sound)
(use Motion)
(use Actor)

(class Door of Prop
	(properties
		entranceTo 0
		locked 0
		openSnd 40
		closeSnd 41
		state 0
		doubleDoor 0
		forceOpen 0
		caller 0
		moveToX 0
		moveToY 0
		enterType 2
		exitType 2
		closeScript 0
		openScript 0
	)

	(method (init)
		(self approachVerbs: 3) ; Do
		(if (or forceOpen (and gPrevRoomNum (== gPrevRoomNum entranceTo)))
			(= state 2)
			(|= signal $4000)
			(if doubleDoor
				(doubleDoor ignoreActors: 1)
			)
		)
		(if (== state 0)
			(= cel 0)
			(if doubleDoor
				(doubleDoor setCel: 0)
			)
		else
			(= cel (- (NumCels self) 1))
			(if doubleDoor
				(doubleDoor setCel: 255)
			)
		)
		(super init:)
		(if (== state 2)
			(if closeScript
				(self setScript: closeScript)
			else
				(switch enterType
					(0
						(HandsOff)
						(gEgo
							posn: moveToX moveToY
							setMotion: PolyPath approachX approachY self
						)
					)
					(1
						(gEgo
							edgeHit: EDGE_NONE
							posn: approachX approachY
							setHeading: heading
						)
						(self close:)
					)
					(2
						(self close:)
					)
				)
			)
		else
			(self stopUpd:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== state 2)
					(self close:)
				else
					(self open:)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (open)
		(if locked
			(TPrint 21 0) ; "This door is locked."
		else
			(HandsOff)
			(= state 1)
			(self setCycle: End self)
			(if openSnd
				((Sound new:) number: openSnd play:)
			)
			(if doubleDoor
				(doubleDoor setCycle: End)
			)
		)
	)

	(method (close)
		(= state 3)
		(self setCycle: Beg self)
		(if closeSnd
			((Sound new:) number: closeSnd play:)
		)
		(if doubleDoor
			(doubleDoor setCycle: Beg)
		)
	)

	(method (cue)
		(switch state
			(3
				(= state 0)
				(self stopUpd: ignoreActors: 0)
				(if doubleDoor
					(doubleDoor ignoreActors: 0)
				)
				(if caller
					(caller cue:)
				)
			)
			(1
				(= state 2)
				(self stopUpd: ignoreActors: 1)
				(if doubleDoor
					(doubleDoor ignoreActors: 1)
				)
				(if caller
					(caller cue:)
				)
				(if openScript
					(self setScript: openScript)
				else
					(switch exitType
						(0
							(if (or moveToX moveToY)
								(gEgo
									illegalBits: 0
									setMotion: PolyPath moveToX moveToY self
								)
							)
						)
						(1
							(if (or moveToX moveToY)
								(gEgo
									setMotion: PolyPath moveToX moveToY self
								)
							)
						)
						(2
							(self cue:)
						)
					)
				)
			)
			(else
				(cond
					((and (== (gEgo x:) moveToX) (== (gEgo y:) moveToY))
						(if entranceTo
							(switch entranceTo
								((gCurRoom north:)
									(gEgo edgeHit: EDGE_TOP)
								)
								((gCurRoom south:)
									(gEgo edgeHit: EDGE_BOTTOM)
								)
								((gCurRoom west:)
									(gEgo edgeHit: EDGE_LEFT)
								)
								((gCurRoom east:)
									(gEgo edgeHit: EDGE_RIGHT)
								)
							)
							(gCurRoom newRoom: entranceTo)
						else
							(self close:)
						)
					)
					(
						(and
							(== (gEgo x:) approachX)
							(== (gEgo y:) approachY)
						)
						(self close:)
					)
				)
				(HandsOn)
			)
		)
	)
)

