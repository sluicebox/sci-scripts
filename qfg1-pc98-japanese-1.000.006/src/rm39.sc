;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	rm39 0
	swordMusic 1
)

(instance swordMusic of Sound
	(properties)
)

(instance rightGuard of Prop
	(properties
		y 90
		x 179
		view 39
	)
)

(instance leftGuard of Prop
	(properties
		y 90
		x 140
		view 39
		loop 1
	)
)

(instance castleDoor of View
	(properties
		y 88
		x 159
		view 39
		loop 2
	)
)

(instance rm39 of Rm
	(properties
		picture 39
		style 5
		horizon 125
		east 40
		south 37
		west 38
	)

	(method (dispose)
		(if (>= gClock 3000)
			(ClearFlag 239)
		)
		(super dispose:)
	)

	(method (init &tmp temp0)
		(Load rsVIEW 39)
		(if
			(and
				(< 0 gTimeOfDay 4)
				(not (IsFlag 249))
				(!= global267 gDay)
			)
			(LoadMany rsSCRIPT 212 221 222 223 224 220 218 217 216)
			(LoadMany rsVIEW 639 638 501 503 514)
		)
		(SolvePuzzle 660 1)
		(SL enable:)
		(super init: &rest)
		(if (not gNight)
			(rightGuard init: stopUpd: addToPic:)
			(leftGuard init: stopUpd: addToPic:)
		)
		(castleDoor init: stopUpd: addToPic:)
		(= temp0 (gEgo y:))
		(NormalEgo)
		(gEgo init:)
		(= global114 0)
		(switch gPrevRoomNum
			(38
				(gEgo posn: 1 temp0 setMotion: MoveTo 15 temp0)
			)
			(40
				(gEgo posn: 319 temp0 setMotion: MoveTo 305 temp0)
			)
			(41
				(gEgo posn: global105 125 setMotion: MoveTo global105 135)
			)
			(else
				(gEgo posn: 160 189 setMotion: MoveTo 160 170)
			)
		)
		(self setLocales: 807)
		(if
			(and
				(< 0 gTimeOfDay 4)
				(not (IsFlag 249))
				(!= global267 gDay)
			)
			(cond
				((IsFlag 239)
					((ScriptID 221 0) init:) ; theMaster
					(self setScript: (ScriptID 222 1)) ; intro2
				)
				((> (Random 0 100) 50)
					((ScriptID 221 0) setCycle: Walk init:) ; theMaster
					(SetFlag 239)
					(self setScript: (ScriptID 222 0)) ; intro
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (gEgo edgeHit:) EDGE_TOP)
			(cond
				((< (gEgo x:) 100)
					(gEgo x: 1)
				)
				((> (gEgo x:) 203)
					(gEgo x: 318)
				)
				(else
					(gEgo x: (* (- (gEgo x:) 97) 3))
				)
			)
			(gCurRoom newRoom: 41)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look>')
						(cond
							(
								(Said
									'[<at,around][/!*,area,courtyard,street,field]'
								)
								(HighPrint 39 0) ; "You are in the courtyard of Castle Spielburg."
							)
							((Said '/ground,brick,flagstone')
								(HighPrint 39 1) ; "The courtyard is paved with granite paving stones, carefully placed by a skilled craftsman."
							)
							((Said '/man')
								(if gNight
									(HighPrint 39 2) ; "There is nobody else here."
								else
									(HighPrint 39 3) ; "There are two guards near the castle door."
								)
							)
							((Said '/master[<weapon]')
								(HighPrint 39 4) ; "He isn't here at the moment."
							)
							((Said '/east,stable')
								(HighPrint 39 5) ; "What you see, along with what you smell, gives the impression that the building on the east side of the courtyard contains the stables."
							)
							((Said '/west,barrack')
								(HighPrint 39 6) ; "On the west side of the courtyard is a building that looks like soldier's barracks."
								(if (not gNight)
									(HighPrint 39 7) ; "As a matter of fact, there's a soldier sleeping in front of it now."
								)
							)
							((Said '/north,castle,door,guard')
								(HighPrint 39 8) ; "The door to the Baron's castle is well guarded."
							)
							((Said '/south,gate,gatehouse,pit')
								(HighPrint 39 9) ; "As you look back at the castle gate, you see a line of bushes along the south wall and the gatehouse and portcullis."
							)
						)
					)
					((and (not gNight) (Said 'japaneserestorsleep>')))
					((or (Said 'nap,nap') (Said 'go[<to]/nap,nap'))
						(if gNight
							(HighPrint 39 10) ; "You barely get to sleep when you hear the guards searching the castle grounds for bums. You decide it's time to make like a tree and leave."
							(if (< 750 gClock 2550)
								(FixTime 21)
							)
							(gCurRoom newRoom: 37)
						else
							(HighPrint 39 11) ; "There are too many guards around."
						)
					)
				)
			)
		)
	)
)

