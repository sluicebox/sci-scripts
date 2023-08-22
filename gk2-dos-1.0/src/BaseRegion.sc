;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15000)
(include sci.sh)
(use Main)
(use n011)
(use Array)
(use Timer)
(use Game)
(use Actor)
(use System)

(public
	BaseRegion 0
	Wolf 1
	wolfTimer 2
	doorLeft 3
	doorMid 4
	doorRight 5
)

(class BaseRegion of Rgn
	(properties
		modNum 1180
		keep 1
		baseDoors 0
		baseRooms 0
		musicOn 0
		waitForFade 1
	)

	(method (init)
		(super init: &rest)
		(if (not musicOn)
			(= musicOn 1)
			(Lock rsAUDIO 15000 1)
			(gGk2Music setLoop: -1 number: 15000 play:)
		)
		((ScriptID 0 4) loop: 15) ; inventoryButton
		(UpdateScreenItem (ScriptID 0 4)) ; inventoryButton
		((ScriptID 0 5) loop: 2 cel: 4 active: 0) ; recButton
		(UpdateScreenItem (ScriptID 0 5)) ; recButton
		((ScriptID 0 7) mask:) ; movieButton
		(UpdateScreenItem (ScriptID 0 7)) ; movieButton
		(= baseDoors (IntArray new: 17))
		(room1 init:)
		(room2 init:)
		(room3 init:)
		(room4 init:)
		(room5 init:)
		(room6 init:)
		(room7 init:)
		(room8 init:)
		(room9 init:)
		(room10 init:)
		(room11 init:)
		(room12 init:)
		(room13 init:)
		(= baseRooms
			(IDArray
				newWith:
					13
					room1
					room2
					room3
					room4
					room5
					room6
					room7
					room8
					room9
					room10
					room11
					room12
					room13
			)
		)
		(doorLeft init: hide:)
		(doorMid init: hide:)
		(doorRight init: hide:)
		(Wolf init:)
	)

	(method (checkStatus)
		(if
			(or
				(self blockedIn: (Wolf roomNum:))
				(self blockedIn: (gCurRoom roomNum:))
			)
			(SetFlag 811)
			(= global143 (gCurRoom roomNum:))
			(= global142 (gCurRoom curDir:))
			(PlayScene 912 0 11871) ; rm11871
		)
	)

	(method (blockedIn param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (baseRooms at: (- param1 1)))
		(= temp1 (temp0 westPath:))
		(= temp2 (temp0 eastPath:))
		(= temp3 (temp0 northPath:))
		(= temp4 (temp0 southPath:))
		(if (== (Wolf roomNum:) param1)
			(= temp5 (gCurRoom roomNum:))
		else
			(= temp5 (Wolf roomNum:))
		)
		(cond
			((not (or temp3 temp2 temp4 temp1))
				(return 1)
			)
			(
				(or
					(and
						temp3
						(not (or temp2 temp4 temp1))
						(not
							(or
								((baseRooms at: (- temp3 1)) northPath:)
								((baseRooms at: (- temp3 1)) eastPath:)
								((baseRooms at: (- temp3 1)) westPath:)
							)
						)
						(!= temp5 temp3)
					)
					(and
						temp2
						(not (or temp3 temp4 temp1))
						(not
							(or
								((baseRooms at: (- temp2 1)) northPath:)
								((baseRooms at: (- temp2 1)) eastPath:)
								((baseRooms at: (- temp2 1)) southPath:)
							)
						)
						(!= temp5 temp2)
					)
					(and
						temp4
						(not (or temp3 temp2 temp1))
						(not
							(or
								((baseRooms at: (- temp4 1)) westPath:)
								((baseRooms at: (- temp4 1)) eastPath:)
								((baseRooms at: (- temp4 1)) southPath:)
							)
						)
						(!= temp5 temp4)
					)
					(and
						temp1
						(not (or temp3 temp2 temp4))
						(not
							(or
								((baseRooms at: (- temp1 1)) westPath:)
								((baseRooms at: (- temp1 1)) northPath:)
								((baseRooms at: (- temp1 1)) southPath:)
							)
						)
						(!= temp5 temp1)
					)
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 10)
					(baseDoors at: 14)
					(baseDoors at: 1)
					(baseDoors at: 8)
					(baseDoors at: 15)
					(not (OneOf (Wolf roomNum:) 3 4 7 8 11 12 13))
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 10)
					(baseDoors at: 14)
					(baseDoors at: 2)
					(baseDoors at: 9)
					(baseDoors at: 16)
					(not (OneOf (Wolf roomNum:) 4 8 12 13))
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 3)
					(baseDoors at: 4)
					(baseDoors at: 5)
					(baseDoors at: 6)
					(OneOf (Wolf roomNum:) 1 2 3 4)
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 10)
					(baseDoors at: 11)
					(baseDoors at: 12)
					(baseDoors at: 13)
					(not (OneOf (Wolf roomNum:) 10 11 12 13))
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 1)
					(baseDoors at: 8)
					(baseDoors at: 10)
					(baseDoors at: 11)
					(OneOf (Wolf roomNum:) 1 2 5 6)
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 3)
					(baseDoors at: 4)
					(baseDoors at: 8)
					(baseDoors at: 15)
					(baseDoors at: 10)
					(baseDoors at: 14)
					(OneOf (Wolf roomNum:) 5 6 10)
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 3)
					(baseDoors at: 4)
					(baseDoors at: 8)
					(baseDoors at: 15)
					(not (OneOf (Wolf roomNum:) 5 6 10))
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 0)
					(baseDoors at: 2)
					(baseDoors at: 7)
					(baseDoors at: 9)
					(baseDoors at: 11)
					(baseDoors at: 12)
					(or
						(and
							(OneOf (Wolf roomNum:) 2 3 6 7)
							(not (OneOf (gCurRoom roomNum:) 2 3 6 7))
						)
						(and
							(OneOf (gCurRoom roomNum:) 2 3 6 7)
							(not (OneOf (Wolf roomNum:) 2 3 6 7))
						)
					)
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 4)
					(baseDoors at: 5)
					(baseDoors at: 7)
					(baseDoors at: 9)
					(baseDoors at: 14)
					(baseDoors at: 16)
					(or
						(and
							(OneOf (Wolf roomNum:) 6 7 10 11)
							(not (OneOf (gCurRoom roomNum:) 6 7 10 11))
						)
						(and
							(OneOf (gCurRoom roomNum:) 6 7 10 11)
							(not (OneOf (Wolf roomNum:) 6 7 10 11))
						)
					)
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 5)
					(baseDoors at: 6)
					(baseDoors at: 8)
					(baseDoors at: 15)
					(not (OneOf (Wolf roomNum:) 7 8 11 12))
				)
				(return 1)
			)
			(
				(and
					(baseDoors at: 1)
					(baseDoors at: 8)
					(baseDoors at: 12)
					(baseDoors at: 13)
					(or
						(and
							(OneOf (Wolf roomNum:) 3 4 7 8)
							(not (OneOf (gCurRoom roomNum:) 3 4 7 8))
						)
						(and
							(OneOf (gCurRoom roomNum:) 3 4 7 8)
							(not (OneOf (Wolf roomNum:) 3 4 7 8))
						)
					)
				)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (dispose)
		(Wolf dispose:)
		(baseDoors dispose:)
		(baseRooms dispose:)
		(doorLeft dispose: 1)
		(doorMid dispose: 1)
		(doorRight dispose: 1)
		(gThePlane setRect: 12 15 627 349)
		((ScriptID 0 4) mask:) ; inventoryButton
		(UpdateScreenItem (ScriptID 0 4)) ; inventoryButton
		(super dispose: &rest)
	)
)

(class Wolf of Obj
	(properties
		roomNum 12
	)

	(method (init)
		(super init: &rest)
		(wolfTimer setReal: wolfTimer 8)
	)

	(method (gabeAway param1 &tmp temp0 temp1)
		(= temp0 ((BaseRegion baseRooms:) at: (- param1 1)))
		(if (== gCurRoomNum 11871)
			(= temp1 global143)
		else
			(= temp1 (- gCurRoomNum 15000))
		)
		(if
			(or
				(== param1 temp1)
				(== (temp0 northPath:) temp1)
				(== (temp0 eastPath:) temp1)
				(== (temp0 southPath:) temp1)
				(== (temp0 westPath:) temp1)
			)
			(return 0)
		else
			(return 1)
		)
	)

	(method (makeMove &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 ((BaseRegion baseRooms:) at: (- roomNum 1)))
		(= temp1 (temp0 westPath:))
		(= temp2 (temp0 eastPath:))
		(= temp3 (temp0 northPath:))
		(= temp4 (temp0 southPath:))
		(= temp5 (temp0 col:))
		(= temp6 (temp0 row:))
		(if (== gCurRoomNum 11871)
			(= temp7 global143)
		else
			(= temp7 (- gCurRoomNum 15000))
		)
		(cond
			(
				(and
					(> temp5 1)
					temp1
					(self gabeAway: temp1)
					(or
						(!= temp1 1)
						(and (not temp2) (== temp4 temp7))
						(and (not temp4) (== temp2 temp7))
					)
					(or
						(== temp1 9)
						(and
							(((BaseRegion baseRooms:) at: (- temp1 1))
								northPath:
							)
							(((BaseRegion baseRooms:)
									at:
										(-
											(((BaseRegion baseRooms:)
													at: (- temp1 1)
												)
												northPath:
											)
											1
										)
								)
								eastPath:
							)
						)
						(((BaseRegion baseRooms:) at: (- temp1 1)) southPath:)
						(((BaseRegion baseRooms:) at: (- temp1 1)) westPath:)
						(and (not (or temp3 temp2)) (== temp4 temp7))
						(and (not (or temp3 temp4)) (== temp2 temp7))
						(and (not (or temp2 temp4)) (== temp3 temp7))
					)
				)
				(= roomNum temp1)
			)
			(
				(and
					(< temp6 3)
					temp4
					(self gabeAway: temp4)
					(or
						(!= temp4 12)
						(and (not temp1) (== temp3 temp7))
						(and (not temp3) (== temp1 temp7))
					)
					(or
						(((BaseRegion baseRooms:) at: (- temp4 1)) eastPath:)
						(((BaseRegion baseRooms:) at: (- temp4 1)) southPath:)
						(((BaseRegion baseRooms:) at: (- temp4 1)) westPath:)
						(and (not (or temp1 temp3)) (== temp2 temp7))
						(and (not (or temp1 temp2)) (== temp3 temp7))
						(and (not (or temp3 temp2)) (== temp1 temp7))
					)
				)
				(= roomNum temp4)
			)
			((== roomNum 1) ; logoRm
				(cond
					((and temp4 (self gabeAway: temp4))
						(= roomNum temp4)
					)
					((and temp2 (self gabeAway: temp2))
						(= roomNum temp2)
					)
					(
						(or
							(not (or temp4 temp2))
							(and (not temp4) (== temp7 2))
							(and (not temp2) (== temp7 5))
						)
						(SetFlag 813)
						(= global143 (gCurRoom roomNum:))
						(= global142 (gCurRoom curDir:))
						(PlayScene 912 0 11871) ; rm11871
					)
					(else 0)
				)
			)
			((== roomNum 12) ; endChapter
				(cond
					((and temp1 (self gabeAway: temp1))
						(= roomNum temp1)
					)
					((and temp3 (self gabeAway: temp3))
						(= roomNum temp3)
					)
					((self gabeAway: roomNum) 0)
					(else
						(= roomNum 13)
					)
				)
			)
			((== roomNum 13)
				(if (and temp3 (self gabeAway: temp3))
					(= roomNum temp3)
				else
					0
				)
			)
			((== temp6 3)
				(cond
					((and temp3 (self gabeAway: temp3))
						(= roomNum temp3)
					)
					((self gabeAway: roomNum) 0)
					((and temp2 (self gabeAway: temp2))
						(= roomNum temp2)
					)
				)
			)
			((== temp6 2)
				(cond
					(
						(or
							(and temp2 (self gabeAway: temp2))
							(and
								(!= temp7 temp2)
								(!= temp7 gCurRoom)
								temp2
								(not (or temp3 temp1 temp4))
							)
						)
						(= roomNum temp2)
					)
					((self gabeAway: roomNum) 0)
					((and temp3 (self gabeAway: temp3))
						(= roomNum temp3)
					)
				)
			)
			((== temp6 1)
				(cond
					((and temp2 (self gabeAway: temp2))
						(= roomNum temp2)
					)
					((self gabeAway: roomNum) 0)
				)
			)
		)
		(if (== roomNum 9)
			(SetFlag 809)
			(= global143 temp7)
			(if (== gCurRoomNum 11871)
				(gCurRoom notify:)
			else
				(= global143 (gCurRoom roomNum:))
				(= global142 (gCurRoom curDir:))
				(PlayScene 912 0 11871) ; rm11871
			)
		)
	)

	(method (resetTimer)
		(wolfTimer dispose: delete: setReal: wolfTimer 8)
	)

	(method (dispose)
		(if (gTimers contains: wolfTimer)
			(wolfTimer dispose: delete:)
		)
		(super dispose: &rest)
	)
)

(class LinkedRoom of Obj
	(properties
		northPath 0
		eastPath 0
		southPath 0
		westPath 0
		row 0
		col 0
	)

	(method (closeDoor param1 param2)
		(switch param1
			(2
				((BaseRegion baseDoors:) at: 0 1)
				(((BaseRegion baseRooms:) at: 0) eastPath: 0)
				(((BaseRegion baseRooms:) at: 1) westPath: 0)
				(if
					(and
						((BaseRegion baseDoors:) at: 7)
						((BaseRegion baseDoors:) at: 14)
					)
					(gGame changeScore: 1168)
				)
			)
			(3
				((BaseRegion baseDoors:) at: 1 1)
				(((BaseRegion baseRooms:) at: 1) eastPath: 0)
				(((BaseRegion baseRooms:) at: 2) westPath: 0)
			)
			(4
				((BaseRegion baseDoors:) at: 2 1)
				(((BaseRegion baseRooms:) at: 2) eastPath: 0)
				(((BaseRegion baseRooms:) at: 3) westPath: 0)
			)
			(5
				((BaseRegion baseDoors:) at: 3 1)
				(((BaseRegion baseRooms:) at: 0) southPath: 0)
				(((BaseRegion baseRooms:) at: 4) northPath: 0)
			)
			(6
				(if (== param2 0)
					((BaseRegion baseDoors:) at: 4 1)
					(((BaseRegion baseRooms:) at: 1) southPath: 0)
					(((BaseRegion baseRooms:) at: 5) northPath: 0)
				else
					((BaseRegion baseDoors:) at: 7 1)
					(((BaseRegion baseRooms:) at: 4) eastPath: 0)
					(((BaseRegion baseRooms:) at: 5) westPath: 0)
					(if
						(and
							((BaseRegion baseDoors:) at: 0)
							((BaseRegion baseDoors:) at: 14)
						)
						(gGame changeScore: 1168)
					)
				)
			)
			(7
				(if (== param2 0)
					((BaseRegion baseDoors:) at: 5 1)
					(((BaseRegion baseRooms:) at: 2) southPath: 0)
					(((BaseRegion baseRooms:) at: 6) northPath: 0)
				else
					((BaseRegion baseDoors:) at: 8 1)
					(((BaseRegion baseRooms:) at: 5) eastPath: 0)
					(((BaseRegion baseRooms:) at: 6) westPath: 0)
				)
			)
			(8
				(if (== param2 0)
					((BaseRegion baseDoors:) at: 6 1)
					(((BaseRegion baseRooms:) at: 3) southPath: 0)
					(((BaseRegion baseRooms:) at: 7) northPath: 0)
				else
					((BaseRegion baseDoors:) at: 9 1)
					(((BaseRegion baseRooms:) at: 6) eastPath: 0)
					(((BaseRegion baseRooms:) at: 7) westPath: 0)
				)
			)
			(9
				((BaseRegion baseDoors:) at: 10 1)
				(((BaseRegion baseRooms:) at: 4) southPath: 0)
				(((BaseRegion baseRooms:) at: 8) northPath: 0)
				(if ((BaseRegion baseDoors:) at: 14)
					(gGame changeScore: 1168)
				)
			)
			(10
				(if (== param2 0)
					((BaseRegion baseDoors:) at: 11 1)
					(((BaseRegion baseRooms:) at: 5) southPath: 0)
					(((BaseRegion baseRooms:) at: 9) northPath: 0)
				else
					((BaseRegion baseDoors:) at: 14 1)
					(((BaseRegion baseRooms:) at: 8) eastPath: 0)
					(((BaseRegion baseRooms:) at: 9) westPath: 0)
					(if
						(or
							((BaseRegion baseDoors:) at: 10)
							(and
								((BaseRegion baseDoors:) at: 0)
								((BaseRegion baseDoors:) at: 7)
							)
						)
						(gGame changeScore: 1168)
					)
				)
			)
			(11
				(if (== param2 0)
					((BaseRegion baseDoors:) at: 12 1)
					(((BaseRegion baseRooms:) at: 6) southPath: 0)
					(((BaseRegion baseRooms:) at: 10) northPath: 0)
				else
					((BaseRegion baseDoors:) at: 15 1)
					(((BaseRegion baseRooms:) at: 9) eastPath: 0)
					(((BaseRegion baseRooms:) at: 10) westPath: 0)
				)
			)
			(12
				(if (== param2 0)
					((BaseRegion baseDoors:) at: 13 1)
					(((BaseRegion baseRooms:) at: 7) southPath: 0)
					(((BaseRegion baseRooms:) at: 11) northPath: 0)
				else
					((BaseRegion baseDoors:) at: 16 1)
					(((BaseRegion baseRooms:) at: 10) eastPath: 0)
					(((BaseRegion baseRooms:) at: 11) westPath: 0)
				)
			)
		)
	)
)

(instance room1 of LinkedRoom
	(properties
		eastPath 2
		southPath 5
		row 1
		col 1
	)
)

(instance room2 of LinkedRoom
	(properties
		eastPath 3
		southPath 6
		westPath 1
		row 1
		col 2
	)
)

(instance room3 of LinkedRoom
	(properties
		eastPath 4
		southPath 7
		westPath 2
		row 1
		col 3
	)
)

(instance room4 of LinkedRoom
	(properties
		southPath 8
		westPath 3
		row 1
		col 4
	)
)

(instance room5 of LinkedRoom
	(properties
		northPath 1
		eastPath 6
		southPath 9
		row 2
		col 1
	)
)

(instance room6 of LinkedRoom
	(properties
		northPath 2
		eastPath 7
		southPath 10
		westPath 5
		row 2
		col 2
	)
)

(instance room7 of LinkedRoom
	(properties
		northPath 3
		eastPath 8
		southPath 11
		westPath 6
		row 2
		col 3
	)
)

(instance room8 of LinkedRoom
	(properties
		northPath 4
		southPath 12
		westPath 7
		row 2
		col 4
	)
)

(instance room9 of LinkedRoom
	(properties
		northPath 5
		eastPath 10
		row 3
		col 1
	)
)

(instance room10 of LinkedRoom
	(properties
		northPath 6
		eastPath 11
		westPath 9
		row 3
		col 2
	)
)

(instance room11 of LinkedRoom
	(properties
		northPath 7
		eastPath 12
		westPath 10
		row 3
		col 3
	)
)

(instance room12 of LinkedRoom
	(properties
		northPath 8
		southPath 13
		westPath 11
		row 3
		col 4
	)
)

(instance room13 of LinkedRoom
	(properties
		northPath 12
		row 4
		col 4
	)
)

(instance doorLeft of View
	(properties
		x 282
		y 208
		view 30152
	)

	(method (init)
		(super init: &rest)
		((gUser hotCursor:) delete: self)
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose param1)
		(if (and argc param1)
			(super dispose:)
		)
	)
)

(instance doorMid of View
	(properties
		x 282
		y 208
		view 30152
	)

	(method (init)
		(super init: &rest)
		((gUser hotCursor:) delete: self)
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose param1)
		(if (and argc param1)
			(super dispose:)
		)
	)
)

(instance doorRight of View
	(properties
		x 282
		y 208
		view 30152
	)

	(method (init)
		(super init: &rest)
		((gUser hotCursor:) delete: self)
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose param1)
		(if (and argc param1)
			(super dispose:)
		)
	)
)

(instance wolfTimer of Timer
	(properties)

	(method (cue)
		(Wolf makeMove:)
		(self setReal: self 8)
	)
)

