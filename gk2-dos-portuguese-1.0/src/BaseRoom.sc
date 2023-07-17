;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1500)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use BaseRegion)
(use Str)
(use Print)
(use Polygon)
(use Feature)
(use System)

(procedure (localproc_0 param1 param2 param3 param4)
	((gUser sel_715:) hide:)
	(gCast eachElementDo: #hide)
	(localproc_1 param1)
	(localproc_1 param2)
	(if param3
		(localproc_1 param3)
	)
	(gCurRoom newRoom: param4)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2)
	(if (ResCheck 151 param1) ; VMD
		(= temp1 (Str newWith: 10 {}))
		(temp1 format: {%d.VMD} param1)
		(gTopMessage sel_867: param1)
		(PlayVMD 0 (temp1 data:) 0) ; Open
		(PlayVMD 23 16 236) ; RestrictPalette
		(PlayVMD 1 12 15 65) ; Put
		(PlayVMD 21 0 0 -1 -1) ; Black
		(PlayVMD 14 7) ; WaitEvent
		(gTopMessage sel_867:)
		(PlayVMD 6) ; Close
	else
		(Printf {*** %d.vmd Not Found! ***} param1)
	)
	(while ((= temp2 (Event new: 3)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
)

(class BaseRoom of GK2Room
	(properties
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 1
	)

	(method (init)
		(Load rsPIC BAD_SELECTOR BAD_SELECTOR BAD_SELECTOR BAD_SELECTOR)
		(if (== gPrevRoomNum 11871)
			(= BAD_SELECTOR global142)
		)
		(self sel_914:)
		(= picture BAD_SELECTOR)
		(super init: &rest)
		(plane setRect: 64932 15 1244 349)
		(UpdatePlane plane)
		(AddPicAt plane BAD_SELECTOR 616 0)
		(AddPicAt plane BAD_SELECTOR 1232 0)
		(leftSide init:)
		(rightSide init:)
		(self sel_915:)
		((gUser sel_715:) sel_737:)
		(if (not (Wolf sel_900: (Wolf sel_880:)))
			(Wolf sel_902: sel_901:)
		)
		(if (== (- gCurRoomNum 15000) (Wolf sel_880:))
			(= global143 BAD_SELECTOR)
			(= global142 (gCurRoom sel_879:))
			(SetFlag 810)
			((ScriptID 15000 2) dispose: delete:) ; wolfTimer
			(BaseRegion keep: 0)
			(gGk2Music stop:)
			(PlayScene 3930 0 666) ; uDie
		)
	)

	(method (BAD_SELECTOR param1)
		(cond
			((> param1 0)
				(if (< BAD_SELECTOR 3)
					(++ BAD_SELECTOR)
				else
					(= BAD_SELECTOR 0)
				)
			)
			(BAD_SELECTOR
				(-- BAD_SELECTOR)
			)
			(else
				(= BAD_SELECTOR 3)
			)
		)
	)

	(method (BAD_SELECTOR)
		(switch BAD_SELECTOR
			(0
				(= BAD_SELECTOR BAD_SELECTOR)
				(= BAD_SELECTOR BAD_SELECTOR)
				(= BAD_SELECTOR BAD_SELECTOR)
			)
			(1
				(= BAD_SELECTOR BAD_SELECTOR)
				(= BAD_SELECTOR BAD_SELECTOR)
				(= BAD_SELECTOR BAD_SELECTOR)
			)
			(2
				(= BAD_SELECTOR BAD_SELECTOR)
				(= BAD_SELECTOR BAD_SELECTOR)
				(= BAD_SELECTOR BAD_SELECTOR)
			)
			(3
				(= BAD_SELECTOR BAD_SELECTOR)
				(= BAD_SELECTOR BAD_SELECTOR)
				(= BAD_SELECTOR BAD_SELECTOR)
			)
		)
	)

	(method (BAD_SELECTOR)
		(switch BAD_SELECTOR
			(1
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 0))
								((BaseRegion sel_890:) at: 1)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1517 194
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 4) hide:) ; doorMid
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 0))
								((BaseRegion sel_890:) at: 1)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 901 194
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 3))
								((BaseRegion sel_890:) at: 10)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1514 208
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 3))
								((BaseRegion sel_890:) at: 10)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 898 208
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 0))
								((BaseRegion sel_890:) at: 1)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 285 194
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 3))
								((BaseRegion sel_890:) at: 10)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 282 208
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
				)
			)
			(2
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 1))
								((BaseRegion sel_890:) at: 2)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1514 196
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 4) hide:) ; doorMid
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 1))
								((BaseRegion sel_890:) at: 2)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 898 196
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 4))
								((BaseRegion sel_890:) at: 11)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1527 203
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 4))
								((BaseRegion sel_890:) at: 11)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 911 203
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 1))
								((BaseRegion sel_890:) at: 2)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 282 196
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 4))
								((BaseRegion sel_890:) at: 11)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 295 203
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
				)
			)
			(3
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 1))
								((BaseRegion sel_890:) at: 0)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30111
								setLoop: 0
								posn: 283 192
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 5))
								((BaseRegion sel_890:) at: 12)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30153
								setLoop: 1
								posn: 1524 183
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 5))
								((BaseRegion sel_890:) at: 12)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30153
								setLoop: 1
								posn: 908 183
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 1))
								((BaseRegion sel_890:) at: 0)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30111
								setLoop: 0
								posn: 1515 192
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 1))
								((BaseRegion sel_890:) at: 0)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30111
								setLoop: 0
								posn: 899 192
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 5))
								((BaseRegion sel_890:) at: 12)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30153
								setLoop: 1
								posn: 292 183
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
					)
				)
			)
			(4
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 2))
								((BaseRegion sel_890:) at: 1)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 0
								posn: 279 192
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 6))
								((BaseRegion sel_890:) at: 13)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1513 203
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 6))
								((BaseRegion sel_890:) at: 13)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 897 203
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 2))
								((BaseRegion sel_890:) at: 1)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 0
								posn: 1511 192
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 2))
								((BaseRegion sel_890:) at: 1)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 0
								posn: 895 192
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 6))
								((BaseRegion sel_890:) at: 13)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 281 203
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
					)
				)
			)
			(5
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 7))
								((BaseRegion sel_890:) at: 8)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1523 204
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 4) hide:) ; doorMid
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 7))
								((BaseRegion sel_890:) at: 8)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 907 204
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						((ScriptID 15000 5) hide:) ; doorRight
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 7))
								((BaseRegion sel_890:) at: 8)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 291 204
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(3
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
				)
			)
			(6
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 8))
								((BaseRegion sel_890:) at: 9)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1522 206
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 4) hide:) ; doorMid
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 8))
								((BaseRegion sel_890:) at: 9)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 906 206
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						((ScriptID 15000 5) hide:) ; doorRight
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 8))
								((BaseRegion sel_890:) at: 9)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 290 206
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(3
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
				)
			)
			(7
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 8))
								((BaseRegion sel_890:) at: 7)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 0
								posn: 289 205
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
						((ScriptID 15000 4) hide:) ; doorMid
					)
					(1
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 8))
								((BaseRegion sel_890:) at: 7)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 0
								posn: 1521 205
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 8))
								((BaseRegion sel_890:) at: 7)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 0
								posn: 905 205
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 5) hide:) ; doorRight
					)
				)
			)
			(8
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 9))
								((BaseRegion sel_890:) at: 8)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 0
								posn: 284 205
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
						((ScriptID 15000 4) hide:) ; doorMid
					)
					(1
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 9))
								((BaseRegion sel_890:) at: 8)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 0
								posn: 1516 205
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 9))
								((BaseRegion sel_890:) at: 8)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 0
								posn: 900 205
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 5) hide:) ; doorRight
					)
				)
			)
			(9
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 10))
								((BaseRegion sel_890:) at: 3)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 0
								posn: 904 209
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 14))
								((BaseRegion sel_890:) at: 15)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1512 203
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 14))
								((BaseRegion sel_890:) at: 15)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 896 203
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 10))
								((BaseRegion sel_890:) at: 3)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 0
								posn: 288 209
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 14))
								((BaseRegion sel_890:) at: 15)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 280 203
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 10))
								((BaseRegion sel_890:) at: 3)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 0
								posn: 1520 209
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 3) hide:) ; doorLeft
					)
				)
			)
			(10
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 11))
								((BaseRegion sel_890:) at: 4)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 0
								posn: 905 205
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 15))
								((BaseRegion sel_890:) at: 16)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 1
								posn: 1518 210
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 15))
								((BaseRegion sel_890:) at: 16)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30152
								setLoop: 1
								posn: 902 210
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 11))
								((BaseRegion sel_890:) at: 4)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 0
								posn: 289 205
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 15))
								((BaseRegion sel_890:) at: 16)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30152
								setLoop: 1
								posn: 286 210
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 11))
								((BaseRegion sel_890:) at: 4)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30152
								setLoop: 0
								posn: 1521 205
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 3) hide:) ; doorLeft
					)
				)
			)
			(11
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 12))
								((BaseRegion sel_890:) at: 5)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30142
								setLoop: 0
								posn: 881 202
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 15))
								((BaseRegion sel_890:) at: 14)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30143
								setLoop: 0
								posn: 268 195
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 12))
								((BaseRegion sel_890:) at: 5)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30142
								setLoop: 0
								posn: 265 202
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 15))
								((BaseRegion sel_890:) at: 14)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30143
								setLoop: 0
								posn: 1500 195
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 4) hide:) ; doorMid
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 15))
								((BaseRegion sel_890:) at: 14)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30143
								setLoop: 0
								posn: 884 195
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 12))
								((BaseRegion sel_890:) at: 5)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30142
								setLoop: 0
								posn: 1497 202
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
					)
				)
			)
			(12
				(switch BAD_SELECTOR
					(0
						(if
							(and
								(not ((BaseRegion sel_890:) at: 13))
								((BaseRegion sel_890:) at: 6)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30146
								setLoop: 0
								posn: 876 196
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 16))
								((BaseRegion sel_890:) at: 15)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30147
								setLoop: 0
								posn: 280 209
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(1
						(if
							(and
								(not ((BaseRegion sel_890:) at: 13))
								((BaseRegion sel_890:) at: 6)
							)
							((ScriptID 15000 3) ; doorLeft
								view: 30146
								setLoop: 0
								posn: 277 209
								show:
							)
						else
							((ScriptID 15000 3) hide:) ; doorLeft
						)
						((ScriptID 15000 4) hide:) ; doorMid
						((ScriptID 15000 5) hide:) ; doorRight
					)
					(2
						(if
							(and
								(not ((BaseRegion sel_890:) at: 16))
								((BaseRegion sel_890:) at: 15)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30147
								setLoop: 0
								posn: 1512 209
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
						((ScriptID 15000 4) hide:) ; doorMid
					)
					(3
						(if
							(and
								(not ((BaseRegion sel_890:) at: 16))
								((BaseRegion sel_890:) at: 15)
							)
							((ScriptID 15000 4) ; doorMid
								view: 30147
								setLoop: 0
								posn: 896 209
								show:
							)
						else
							((ScriptID 15000 4) hide:) ; doorMid
						)
						(if
							(and
								(not ((BaseRegion sel_890:) at: 13))
								((BaseRegion sel_890:) at: 6)
							)
							((ScriptID 15000 5) ; doorRight
								view: 30146
								setLoop: 0
								posn: 1509 209
								show:
							)
						else
							((ScriptID 15000 5) hide:) ; doorRight
						)
						((ScriptID 15000 3) hide:) ; doorLeft
					)
				)
			)
		)
	)

	(method (BAD_SELECTOR param1 param2)
		(switch param1
			(1
				(switch param2
					(1
						(cond
							(((BaseRegion sel_890:) at: 1)
								(localproc_0 15201 15557 15505 15002)
							)
							(((BaseRegion sel_890:) at: 2)
								(localproc_0 15101 15557 15205 15002)
							)
							(else
								(localproc_0 15101 15557 15105 15002)
							)
						)
					)
					(2
						(if ((BaseRegion sel_890:) at: 10)
							(localproc_0 15204 15558 15520 15005)
						else
							(localproc_0 15104 15558 15120 15005)
						)
					)
				)
			)
			(2
				(switch param2
					(1
						(if ((BaseRegion sel_890:) at: 2)
							(localproc_0 15405 15557 15509 15003)
						else
							(localproc_0 15305 15557 15109 15003)
						)
					)
					(2
						(if ((BaseRegion sel_890:) at: 11)
							(localproc_0 15208 15558 15524 15006)
						else
							(localproc_0 15108 15558 15124 15006)
						)
					)
					(3
						(localproc_0 15207 15555 15103 15001)
					)
				)
			)
			(3
				(switch param2
					(1
						(localproc_0 15209 15557 15113 15004)
					)
					(2
						(if ((BaseRegion sel_890:) at: 12)
							(localproc_0 15212 15558 15528 15007)
						else
							(localproc_0 15112 15558 15128 15007)
						)
					)
					(3
						(if ((BaseRegion sel_890:) at: 0)
							(localproc_0 15411 15555 15507 15002)
						else
							(localproc_0 15311 15555 15107 15002)
						)
					)
				)
			)
			(4
				(switch param2
					(2
						(if ((BaseRegion sel_890:) at: 13)
							(localproc_0 15216 15558 15532 15008)
						else
							(localproc_0 15116 15558 15132 15008)
						)
					)
					(3
						(cond
							(((BaseRegion sel_890:) at: 1)
								(localproc_0 15415 15555 15511 15003)
							)
							(((BaseRegion sel_890:) at: 0)
								(localproc_0 15315 15555 15211 15003)
							)
							(else
								(localproc_0 15315 15555 15111 15003)
							)
						)
					)
				)
			)
			(5
				(switch param2
					(0
						(localproc_0 15218 15556 15102 15001)
					)
					(1
						(cond
							(((BaseRegion sel_890:) at: 8)
								(localproc_0 15417 15557 15521 15006)
							)
							(((BaseRegion sel_890:) at: 9)
								(localproc_0 15317 15557 15221 15006)
							)
							(else
								(localproc_0 15317 15557 15121 15006)
							)
						)
					)
					(2
						(localproc_0 15220 15558 15136 15009)
					)
				)
			)
			(6
				(switch param2
					(0
						(localproc_0 15222 15556 15106 15002)
					)
					(1
						(if ((BaseRegion sel_890:) at: 9)
							(localproc_0 15421 15557 15525 15007)
						else
							(localproc_0 15321 15557 15125 15007)
						)
					)
					(2
						(localproc_0 15224 15558 15140 15010)
					)
					(3
						(localproc_0 15223 15555 15119 15005)
					)
				)
			)
			(7
				(switch param2
					(0
						(localproc_0 15226 15556 15110 15003)
					)
					(1
						(localproc_0 15225 15557 15129 15008)
					)
					(2
						(localproc_0 15228 15558 15144 15011)
					)
					(3
						(if ((BaseRegion sel_890:) at: 7)
							(localproc_0 15427 15555 15523 15006)
						else
							(localproc_0 15327 15555 15123 15006)
						)
					)
				)
			)
			(8
				(switch param2
					(0
						(localproc_0 15230 15556 15114 15004)
					)
					(2
						(localproc_0 15232 15558 15148 15012)
					)
					(3
						(cond
							(((BaseRegion sel_890:) at: 8)
								(localproc_0 15431 15555 15527 15007)
							)
							(((BaseRegion sel_890:) at: 7)
								(localproc_0 15331 15555 15227 15007)
							)
							(else
								(localproc_0 15331 15555 15127 15007)
							)
						)
					)
				)
			)
			(9
				(switch param2
					(0
						(if ((BaseRegion sel_890:) at: 3)
							(localproc_0 15234 15556 15518 15005)
						else
							(localproc_0 15134 15556 15118 15005)
						)
					)
					(1
						(cond
							(((BaseRegion sel_890:) at: 15)
								(localproc_0 15233 15557 15537 15010)
							)
							(((BaseRegion sel_890:) at: 16)
								(localproc_0 15133 15557 15237 15010)
							)
							(else
								(localproc_0 15133 15557 15137 15010)
							)
						)
					)
				)
			)
			(10
				(switch param2
					(0
						(if ((BaseRegion sel_890:) at: 4)
							(localproc_0 15238 15556 15522 15006)
						else
							(localproc_0 15138 15556 15122 15006)
						)
					)
					(1
						(if ((BaseRegion sel_890:) at: 16)
							(localproc_0 15437 15557 15541 15011)
						else
							(localproc_0 15337 15557 15141 15011)
						)
					)
					(3
						(localproc_0 15239 15555 15135 15009)
					)
				)
			)
			(11
				(switch param2
					(0
						(if ((BaseRegion sel_890:) at: 5)
							(localproc_0 15442 15556 15526 15007)
						else
							(localproc_0 15342 15556 15126 15007)
						)
					)
					(1
						(localproc_0 15241 15557 15145 15012)
					)
					(3
						(if ((BaseRegion sel_890:) at: 14)
							(localproc_0 15443 15555 15539 15010)
						else
							(localproc_0 15343 15555 15139 15010)
						)
					)
				)
			)
			(12
				(switch param2
					(0
						(if ((BaseRegion sel_890:) at: 6)
							(localproc_0 15246 15556 15530 15008)
						else
							(localproc_0 15146 15556 15130 15008)
						)
					)
					(2
						(localproc_0 15248 15558 0 1300)
					)
					(3
						(cond
							(((BaseRegion sel_890:) at: 15)
								(localproc_0 15247 15555 15543 15011)
							)
							(((BaseRegion sel_890:) at: 14)
								(localproc_0 15147 15555 15243 15011)
							)
							(else
								(localproc_0 15147 15555 15143 15011)
							)
						)
					)
				)
			)
		)
	)

	(method (BAD_SELECTOR)
		(plane setRect: 64932 15 1244 349)
		(UpdatePlane plane)
		(self sel_914:)
		(AddPicAt plane BAD_SELECTOR 0 0)
		(AddPicAt plane BAD_SELECTOR 616 0)
		(AddPicAt plane BAD_SELECTOR 1232 0)
		(self sel_915:)
		(BaseRegion sel_894:)
	)
)

(instance leftSide of ExitFeature
	(properties
		x 646
		y 166
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 617 0 676 0 676 333 617 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (setCursor param1)
		(param1 view: 993 loop: 0 cel: 0)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(62 ; Do
				(= temp1 102)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					((gCurRoom plane:)
						setRect:
							(+ ((gCurRoom plane:) left:) temp1)
							((gCurRoom plane:) top:)
							(+ ((gCurRoom plane:) right:) temp1)
							((gCurRoom plane:) bottom:)
					)
					(= gGameTime (+ gTickOffset (GetTime)))
					(UpdatePlane (gCurRoom plane:))
					(FrameOut)
				)
				(gCurRoom sel_913: -1 sel_914:)
				((gCurRoom plane:) setRect: 64932 15 1244 349)
				(AddPicAt (gCurRoom plane:) (gCurRoom sel_910:) 0 0)
				(AddPicAt (gCurRoom plane:) (gCurRoom sel_911:) 616 0)
				(AddPicAt (gCurRoom plane:) (gCurRoom sel_912:) 1232 0)
				(gCurRoom sel_915:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(UpdatePlane (gCurRoom plane:))
				(gCurRoom cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightSide of ExitFeature
	(properties
		x 1116
		y 166
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1171 0 1232 0 1232 333 1171 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (setCursor param1)
		(param1 view: 993 loop: 1 cel: 0)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(62 ; Do
				(= temp1 102)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					((gCurRoom plane:)
						setRect:
							(- ((gCurRoom plane:) left:) temp1)
							((gCurRoom plane:) top:)
							(- ((gCurRoom plane:) right:) temp1)
							((gCurRoom plane:) bottom:)
					)
					(= gGameTime (+ gTickOffset (GetTime)))
					(UpdatePlane (gCurRoom plane:))
					(FrameOut)
				)
				(gCurRoom sel_913: 1 sel_914:)
				((gCurRoom plane:) setRect: 64932 15 1244 349)
				(AddPicAt (gCurRoom plane:) (gCurRoom sel_910:) 0 0)
				(AddPicAt (gCurRoom plane:) (gCurRoom sel_911:) 616 0)
				(AddPicAt (gCurRoom plane:) (gCurRoom sel_912:) 1232 0)
				(gCurRoom sel_915:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(UpdatePlane (gCurRoom plane:))
				(gCurRoom cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

