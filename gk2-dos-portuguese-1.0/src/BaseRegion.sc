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
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 1
	)

	(method (init)
		(super init: &rest)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR 1)
			(Lock rsAUDIO 15000 1)
			(gGk2Music setLoop: -1 number: 15000 play:)
		)
		((ScriptID 0 4) loop: 15) ; inventoryButton
		(UpdateScreenItem (ScriptID 0 4)) ; inventoryButton
		((ScriptID 0 5) loop: 2 cel: 4 active: 0) ; recButton
		(UpdateScreenItem (ScriptID 0 5)) ; recButton
		((ScriptID 0 7) mask:) ; movieButton
		(UpdateScreenItem (ScriptID 0 7)) ; movieButton
		(= BAD_SELECTOR (IntArray new: 17))
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
		(= BAD_SELECTOR
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

	(method (BAD_SELECTOR)
		(if
			(or
				(self sel_895: (Wolf sel_880:))
				(self sel_895: (gCurRoom sel_880:))
			)
			(SetFlag 811)
			(= global143 (gCurRoom sel_880:))
			(= global142 (gCurRoom sel_879:))
			(PlayScene 912 0 11871) ; rm11871
		)
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (BAD_SELECTOR at: (- param1 1)))
		(= temp1 (temp0 sel_896:))
		(= temp2 (temp0 sel_897:))
		(= temp3 (temp0 sel_898:))
		(= temp4 (temp0 sel_899:))
		(if (== (Wolf sel_880:) param1)
			(= temp5 (gCurRoom sel_880:))
		else
			(= temp5 (Wolf sel_880:))
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
								((BAD_SELECTOR at: (- temp3 1)) sel_898:)
								((BAD_SELECTOR at: (- temp3 1)) sel_897:)
								((BAD_SELECTOR at: (- temp3 1)) sel_896:)
							)
						)
						(!= temp5 temp3)
					)
					(and
						temp2
						(not (or temp3 temp4 temp1))
						(not
							(or
								((BAD_SELECTOR at: (- temp2 1)) sel_898:)
								((BAD_SELECTOR at: (- temp2 1)) sel_897:)
								((BAD_SELECTOR at: (- temp2 1)) sel_899:)
							)
						)
						(!= temp5 temp2)
					)
					(and
						temp4
						(not (or temp3 temp2 temp1))
						(not
							(or
								((BAD_SELECTOR at: (- temp4 1)) sel_896:)
								((BAD_SELECTOR at: (- temp4 1)) sel_897:)
								((BAD_SELECTOR at: (- temp4 1)) sel_899:)
							)
						)
						(!= temp5 temp4)
					)
					(and
						temp1
						(not (or temp3 temp2 temp4))
						(not
							(or
								((BAD_SELECTOR at: (- temp1 1)) sel_896:)
								((BAD_SELECTOR at: (- temp1 1)) sel_898:)
								((BAD_SELECTOR at: (- temp1 1)) sel_899:)
							)
						)
						(!= temp5 temp1)
					)
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 10)
					(BAD_SELECTOR at: 14)
					(BAD_SELECTOR at: 1)
					(BAD_SELECTOR at: 8)
					(BAD_SELECTOR at: 15)
					(not (OneOf (Wolf sel_880:) 3 4 7 8 11 12 13))
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 10)
					(BAD_SELECTOR at: 14)
					(BAD_SELECTOR at: 2)
					(BAD_SELECTOR at: 9)
					(BAD_SELECTOR at: 16)
					(not (OneOf (Wolf sel_880:) 4 8 12 13))
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 3)
					(BAD_SELECTOR at: 4)
					(BAD_SELECTOR at: 5)
					(BAD_SELECTOR at: 6)
					(OneOf (Wolf sel_880:) 1 2 3 4)
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 10)
					(BAD_SELECTOR at: 11)
					(BAD_SELECTOR at: 12)
					(BAD_SELECTOR at: 13)
					(not (OneOf (Wolf sel_880:) 10 11 12 13))
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 1)
					(BAD_SELECTOR at: 8)
					(BAD_SELECTOR at: 10)
					(BAD_SELECTOR at: 11)
					(OneOf (Wolf sel_880:) 1 2 5 6)
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 3)
					(BAD_SELECTOR at: 4)
					(BAD_SELECTOR at: 8)
					(BAD_SELECTOR at: 15)
					(BAD_SELECTOR at: 10)
					(BAD_SELECTOR at: 14)
					(OneOf (Wolf sel_880:) 5 6 10)
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 3)
					(BAD_SELECTOR at: 4)
					(BAD_SELECTOR at: 8)
					(BAD_SELECTOR at: 15)
					(not (OneOf (Wolf sel_880:) 5 6 10))
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 0)
					(BAD_SELECTOR at: 2)
					(BAD_SELECTOR at: 7)
					(BAD_SELECTOR at: 9)
					(BAD_SELECTOR at: 11)
					(BAD_SELECTOR at: 12)
					(or
						(and
							(OneOf (Wolf sel_880:) 2 3 6 7)
							(not (OneOf (gCurRoom sel_880:) 2 3 6 7))
						)
						(and
							(OneOf (gCurRoom sel_880:) 2 3 6 7)
							(not (OneOf (Wolf sel_880:) 2 3 6 7))
						)
					)
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 4)
					(BAD_SELECTOR at: 5)
					(BAD_SELECTOR at: 7)
					(BAD_SELECTOR at: 9)
					(BAD_SELECTOR at: 14)
					(BAD_SELECTOR at: 16)
					(or
						(and
							(OneOf (Wolf sel_880:) 6 7 10 11)
							(not (OneOf (gCurRoom sel_880:) 6 7 10 11))
						)
						(and
							(OneOf (gCurRoom sel_880:) 6 7 10 11)
							(not (OneOf (Wolf sel_880:) 6 7 10 11))
						)
					)
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 5)
					(BAD_SELECTOR at: 6)
					(BAD_SELECTOR at: 8)
					(BAD_SELECTOR at: 15)
					(not (OneOf (Wolf sel_880:) 7 8 11 12))
				)
				(return 1)
			)
			(
				(and
					(BAD_SELECTOR at: 1)
					(BAD_SELECTOR at: 8)
					(BAD_SELECTOR at: 12)
					(BAD_SELECTOR at: 13)
					(or
						(and
							(OneOf (Wolf sel_880:) 3 4 7 8)
							(not (OneOf (gCurRoom sel_880:) 3 4 7 8))
						)
						(and
							(OneOf (gCurRoom sel_880:) 3 4 7 8)
							(not (OneOf (Wolf sel_880:) 3 4 7 8))
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
		(BAD_SELECTOR dispose:)
		(BAD_SELECTOR dispose:)
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
		BAD_SELECTOR 12
	)

	(method (init)
		(super init: &rest)
		(wolfTimer setReal: wolfTimer 8)
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1)
		(= temp0 ((BaseRegion sel_891:) at: (- param1 1)))
		(if (== gCurRoomNum 11871)
			(= temp1 global143)
		else
			(= temp1 (- gCurRoomNum 15000))
		)
		(if
			(or
				(== param1 temp1)
				(== (temp0 sel_898:) temp1)
				(== (temp0 sel_897:) temp1)
				(== (temp0 sel_899:) temp1)
				(== (temp0 sel_896:) temp1)
			)
			(return 0)
		else
			(return 1)
		)
	)

	(method (BAD_SELECTOR &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 ((BaseRegion sel_891:) at: (- BAD_SELECTOR 1)))
		(= temp1 (temp0 sel_896:))
		(= temp2 (temp0 sel_897:))
		(= temp3 (temp0 sel_898:))
		(= temp4 (temp0 sel_899:))
		(= temp5 (temp0 sel_903:))
		(= temp6 (temp0 sel_904:))
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
					(self sel_900: temp1)
					(or
						(!= temp1 1)
						(and (not temp2) (== temp4 temp7))
						(and (not temp4) (== temp2 temp7))
					)
					(or
						(== temp1 9)
						(and
							(((BaseRegion sel_891:) at: (- temp1 1)) sel_898:)
							(((BaseRegion sel_891:)
									at:
										(-
											(((BaseRegion sel_891:)
													at: (- temp1 1)
												)
												sel_898:
											)
											1
										)
								)
								sel_897:
							)
						)
						(((BaseRegion sel_891:) at: (- temp1 1)) sel_899:)
						(((BaseRegion sel_891:) at: (- temp1 1)) sel_896:)
						(and (not (or temp3 temp2)) (== temp4 temp7))
						(and (not (or temp3 temp4)) (== temp2 temp7))
						(and (not (or temp2 temp4)) (== temp3 temp7))
					)
				)
				(= BAD_SELECTOR temp1)
			)
			(
				(and
					(< temp6 3)
					temp4
					(self sel_900: temp4)
					(or
						(!= temp4 12)
						(and (not temp1) (== temp3 temp7))
						(and (not temp3) (== temp1 temp7))
					)
					(or
						(((BaseRegion sel_891:) at: (- temp4 1)) sel_897:)
						(((BaseRegion sel_891:) at: (- temp4 1)) sel_899:)
						(((BaseRegion sel_891:) at: (- temp4 1)) sel_896:)
						(and (not (or temp1 temp3)) (== temp2 temp7))
						(and (not (or temp1 temp2)) (== temp3 temp7))
						(and (not (or temp3 temp2)) (== temp1 temp7))
					)
				)
				(= BAD_SELECTOR temp4)
			)
			((== BAD_SELECTOR 1)
				(cond
					((and temp4 (self sel_900: temp4))
						(= BAD_SELECTOR temp4)
					)
					((and temp2 (self sel_900: temp2))
						(= BAD_SELECTOR temp2)
					)
					(
						(or
							(not (or temp4 temp2))
							(and (not temp4) (== temp7 2))
							(and (not temp2) (== temp7 5))
						)
						(SetFlag 813)
						(= global143 (gCurRoom sel_880:))
						(= global142 (gCurRoom sel_879:))
						(PlayScene 912 0 11871) ; rm11871
					)
					(else 0)
				)
			)
			((== BAD_SELECTOR 12)
				(cond
					((and temp1 (self sel_900: temp1))
						(= BAD_SELECTOR temp1)
					)
					((and temp3 (self sel_900: temp3))
						(= BAD_SELECTOR temp3)
					)
					((self sel_900: BAD_SELECTOR) 0)
					(else
						(= BAD_SELECTOR 13)
					)
				)
			)
			((== BAD_SELECTOR 13)
				(if (and temp3 (self sel_900: temp3))
					(= BAD_SELECTOR temp3)
				else
					0
				)
			)
			((== temp6 3)
				(cond
					((and temp3 (self sel_900: temp3))
						(= BAD_SELECTOR temp3)
					)
					((self sel_900: BAD_SELECTOR) 0)
					((and temp2 (self sel_900: temp2))
						(= BAD_SELECTOR temp2)
					)
				)
			)
			((== temp6 2)
				(cond
					(
						(or
							(and temp2 (self sel_900: temp2))
							(and
								(!= temp7 temp2)
								(!= temp7 gCurRoom)
								temp2
								(not (or temp3 temp1 temp4))
							)
						)
						(= BAD_SELECTOR temp2)
					)
					((self sel_900: BAD_SELECTOR) 0)
					((and temp3 (self sel_900: temp3))
						(= BAD_SELECTOR temp3)
					)
				)
			)
			((== temp6 1)
				(cond
					((and temp2 (self sel_900: temp2))
						(= BAD_SELECTOR temp2)
					)
					((self sel_900: BAD_SELECTOR) 0)
				)
			)
		)
		(if (== BAD_SELECTOR 9)
			(SetFlag 809)
			(= global143 temp7)
			(if (== gCurRoomNum 11871)
				(gCurRoom notify:)
			else
				(= global143 (gCurRoom sel_880:))
				(= global142 (gCurRoom sel_879:))
				(PlayScene 912 0 11871) ; rm11871
			)
		)
	)

	(method (BAD_SELECTOR)
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
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (BAD_SELECTOR param1 param2)
		(switch param1
			(2
				((BaseRegion sel_890:) at: 0 1)
				(((BaseRegion sel_891:) at: 0) sel_897: 0)
				(((BaseRegion sel_891:) at: 1) sel_896: 0)
				(if
					(and
						((BaseRegion sel_890:) at: 7)
						((BaseRegion sel_890:) at: 14)
					)
					(gGame changeScore: 1168)
				)
			)
			(3
				((BaseRegion sel_890:) at: 1 1)
				(((BaseRegion sel_891:) at: 1) sel_897: 0)
				(((BaseRegion sel_891:) at: 2) sel_896: 0)
			)
			(4
				((BaseRegion sel_890:) at: 2 1)
				(((BaseRegion sel_891:) at: 2) sel_897: 0)
				(((BaseRegion sel_891:) at: 3) sel_896: 0)
			)
			(5
				((BaseRegion sel_890:) at: 3 1)
				(((BaseRegion sel_891:) at: 0) sel_899: 0)
				(((BaseRegion sel_891:) at: 4) sel_898: 0)
			)
			(6
				(if (== param2 0)
					((BaseRegion sel_890:) at: 4 1)
					(((BaseRegion sel_891:) at: 1) sel_899: 0)
					(((BaseRegion sel_891:) at: 5) sel_898: 0)
				else
					((BaseRegion sel_890:) at: 7 1)
					(((BaseRegion sel_891:) at: 4) sel_897: 0)
					(((BaseRegion sel_891:) at: 5) sel_896: 0)
					(if
						(and
							((BaseRegion sel_890:) at: 0)
							((BaseRegion sel_890:) at: 14)
						)
						(gGame changeScore: 1168)
					)
				)
			)
			(7
				(if (== param2 0)
					((BaseRegion sel_890:) at: 5 1)
					(((BaseRegion sel_891:) at: 2) sel_899: 0)
					(((BaseRegion sel_891:) at: 6) sel_898: 0)
				else
					((BaseRegion sel_890:) at: 8 1)
					(((BaseRegion sel_891:) at: 5) sel_897: 0)
					(((BaseRegion sel_891:) at: 6) sel_896: 0)
				)
			)
			(8
				(if (== param2 0)
					((BaseRegion sel_890:) at: 6 1)
					(((BaseRegion sel_891:) at: 3) sel_899: 0)
					(((BaseRegion sel_891:) at: 7) sel_898: 0)
				else
					((BaseRegion sel_890:) at: 9 1)
					(((BaseRegion sel_891:) at: 6) sel_897: 0)
					(((BaseRegion sel_891:) at: 7) sel_896: 0)
				)
			)
			(9
				((BaseRegion sel_890:) at: 10 1)
				(((BaseRegion sel_891:) at: 4) sel_899: 0)
				(((BaseRegion sel_891:) at: 8) sel_898: 0)
				(if ((BaseRegion sel_890:) at: 14)
					(gGame changeScore: 1168)
				)
			)
			(10
				(if (== param2 0)
					((BaseRegion sel_890:) at: 11 1)
					(((BaseRegion sel_891:) at: 5) sel_899: 0)
					(((BaseRegion sel_891:) at: 9) sel_898: 0)
				else
					((BaseRegion sel_890:) at: 14 1)
					(((BaseRegion sel_891:) at: 8) sel_897: 0)
					(((BaseRegion sel_891:) at: 9) sel_896: 0)
					(if
						(or
							((BaseRegion sel_890:) at: 10)
							(and
								((BaseRegion sel_890:) at: 0)
								((BaseRegion sel_890:) at: 7)
							)
						)
						(gGame changeScore: 1168)
					)
				)
			)
			(11
				(if (== param2 0)
					((BaseRegion sel_890:) at: 12 1)
					(((BaseRegion sel_891:) at: 6) sel_899: 0)
					(((BaseRegion sel_891:) at: 10) sel_898: 0)
				else
					((BaseRegion sel_890:) at: 15 1)
					(((BaseRegion sel_891:) at: 9) sel_897: 0)
					(((BaseRegion sel_891:) at: 10) sel_896: 0)
				)
			)
			(12
				(if (== param2 0)
					((BaseRegion sel_890:) at: 13 1)
					(((BaseRegion sel_891:) at: 7) sel_899: 0)
					(((BaseRegion sel_891:) at: 11) sel_898: 0)
				else
					((BaseRegion sel_890:) at: 16 1)
					(((BaseRegion sel_891:) at: 10) sel_897: 0)
					(((BaseRegion sel_891:) at: 11) sel_896: 0)
				)
			)
		)
	)
)

(instance room1 of LinkedRoom
	(properties
		BAD_SELECTOR 2
		BAD_SELECTOR 5
		BAD_SELECTOR 1
		BAD_SELECTOR 1
	)
)

(instance room2 of LinkedRoom
	(properties
		BAD_SELECTOR 3
		BAD_SELECTOR 6
		BAD_SELECTOR 1
		BAD_SELECTOR 1
		BAD_SELECTOR 2
	)
)

(instance room3 of LinkedRoom
	(properties
		BAD_SELECTOR 4
		BAD_SELECTOR 7
		BAD_SELECTOR 2
		BAD_SELECTOR 1
		BAD_SELECTOR 3
	)
)

(instance room4 of LinkedRoom
	(properties
		BAD_SELECTOR 8
		BAD_SELECTOR 3
		BAD_SELECTOR 1
		BAD_SELECTOR 4
	)
)

(instance room5 of LinkedRoom
	(properties
		BAD_SELECTOR 1
		BAD_SELECTOR 6
		BAD_SELECTOR 9
		BAD_SELECTOR 2
		BAD_SELECTOR 1
	)
)

(instance room6 of LinkedRoom
	(properties
		BAD_SELECTOR 2
		BAD_SELECTOR 7
		BAD_SELECTOR 10
		BAD_SELECTOR 5
		BAD_SELECTOR 2
		BAD_SELECTOR 2
	)
)

(instance room7 of LinkedRoom
	(properties
		BAD_SELECTOR 3
		BAD_SELECTOR 8
		BAD_SELECTOR 11
		BAD_SELECTOR 6
		BAD_SELECTOR 2
		BAD_SELECTOR 3
	)
)

(instance room8 of LinkedRoom
	(properties
		BAD_SELECTOR 4
		BAD_SELECTOR 12
		BAD_SELECTOR 7
		BAD_SELECTOR 2
		BAD_SELECTOR 4
	)
)

(instance room9 of LinkedRoom
	(properties
		BAD_SELECTOR 5
		BAD_SELECTOR 10
		BAD_SELECTOR 3
		BAD_SELECTOR 1
	)
)

(instance room10 of LinkedRoom
	(properties
		BAD_SELECTOR 6
		BAD_SELECTOR 11
		BAD_SELECTOR 9
		BAD_SELECTOR 3
		BAD_SELECTOR 2
	)
)

(instance room11 of LinkedRoom
	(properties
		BAD_SELECTOR 7
		BAD_SELECTOR 12
		BAD_SELECTOR 10
		BAD_SELECTOR 3
		BAD_SELECTOR 3
	)
)

(instance room12 of LinkedRoom
	(properties
		BAD_SELECTOR 8
		BAD_SELECTOR 13
		BAD_SELECTOR 11
		BAD_SELECTOR 3
		BAD_SELECTOR 4
	)
)

(instance room13 of LinkedRoom
	(properties
		BAD_SELECTOR 12
		BAD_SELECTOR 4
		BAD_SELECTOR 4
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
		((gUser sel_715:) delete: self)
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
		((gUser sel_715:) delete: self)
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
		((gUser sel_715:) delete: self)
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
		(Wolf sel_901:)
		(self setReal: self 8)
	)
)

