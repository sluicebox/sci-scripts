;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)

(class Door of Prop
	(properties
		entranceTo 0
		locked 0
		openSnd 46
		closeSnd 47
		listenVerb 0
		state 0
		doubleDoor 0
		forceOpen 0
		forceClose 1
		caller 0
		moveToX 0
		moveToY 0
		enterType 2
		exitType 2
		closeScript 0
		openScript 0
		doorPoly 0
		polyAdjust 5
	)

	(method (init)
		(self approachVerbs: 4 18) ; Do, skeletonKey
		(if (or forceOpen (and gPrevRoomNum (== gPrevRoomNum entranceTo)))
			(= state 2)
		)
		(super init:)
		(self createPoly:)
		(self ignoreActors: 1)
		(if (== state 0)
			(= cel 0)
			(if doubleDoor
				(doubleDoor setCel: 0)
			)
		else
			(gAltPolys delete: doorPoly)
			(= cel (- (NumCels self) 1))
			(if doubleDoor
				(doubleDoor setCel: 255)
			)
		)
		(if (== state 2)
			(if closeScript
				(self setScript: closeScript)
			else
				(switch enterType
					(0
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
						(if forceClose
							(self close:)
						)
					)
					(2
						(if forceClose
							(self close:)
						)
					)
				)
			)
		else
			(self stopUpd:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== state 2)
					(self close:)
				else
					(self open:)
				)
			)
			(18 ; skeletonKey
				(if cel
					(gMessager say: 1 18 2 0 0 16) ; "This door is already open and there's really no need for you to lock it."
				else
					(gMessager say: 1 18 1 0 0 16) ; "This door won't open this way."
				)
			)
			(listenVerb
				(self listen:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (open)
		(if locked
			(doorSound number: 48 play:) ; sTryingALockedDoor
			(gMessager say: 1 0 3 0 0 16) ; "This door is locked."
		else
			(if (gUser controls:)
				(gGame handsOff:)
			)
			(= state 1)
			(self setCycle: End self)
			(if openSnd
				(doorSound number: openSnd play:)
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
			(doorSound number: closeSnd play:)
		)
		(if doubleDoor
			(doubleDoor setCycle: Beg)
		)
	)

	(method (cue)
		(switch state
			(3
				(= state 0)
				(self stopUpd:)
				(gAltPolys add: doorPoly)
				(if caller
					(caller cue:)
				)
				(if (not (gUser controls:))
					(gGame handsOn: 1)
				)
			)
			(1
				(= state 2)
				(self stopUpd:)
				(gAltPolys delete: doorPoly)
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
							(if (not (gUser controls:))
								(gGame handsOn: 1)
							)
						)
					)
				)
			)
			(else
				(cond
					((and (== (gEgo x:) moveToX) (== (gEgo y:) moveToY))
						(cond
							(entranceTo
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
							)
							(forceClose
								(self close:)
							)
							(caller
								(caller cue:)
							)
						)
					)
					(
						(and
							(== (gEgo x:) approachX)
							(== (gEgo y:) approachY)
						)
						(cond
							(forceClose
								(self close:)
							)
							(caller
								(caller cue:)
							)
						)
					)
				)
			)
		)
	)

	(method (listen)
		(gMessager say: 1 0 4 0 0 16) ; "You don't hear anything."
	)

	(method (createPoly)
		(= doorPoly ((Polygon new:) type: PBarredAccess yourself:))
		(if argc
			(doorPoly init: &rest)
		else
			(doorPoly
				init:
					(- brLeft polyAdjust)
					(+ brBottom polyAdjust)
					(- brLeft polyAdjust)
					(- brTop polyAdjust)
					(+ brRight polyAdjust)
					(- brTop polyAdjust)
					(+ brRight polyAdjust)
					(+ brBottom polyAdjust)
			)
		)
		(gAltPolys add: doorPoly)
	)

	(method (dispose)
		(gAltPolys delete: doorPoly)
		(doorPoly dispose:)
		(super dispose: &rest)
	)
)

(instance doorSound of Sound
	(properties
		flags 5
	)
)

