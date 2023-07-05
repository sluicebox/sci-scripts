;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64948)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use Feature)
(use Sound)
(use File)
(use System)

(public
	Class_64948_0 0
)

(local
	local0
	local1
	local2 = 1
	local3
	local4
	local5
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(Prints {Click left mouse button on top left corner})
	(FrameOut)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(temp0 dispose:)
	)
	(temp0 localize: global116)
	(= temp4 (temp0 y:))
	(= temp3 (temp0 x:))
	(temp0 dispose:)
	(Prints {Click left mouse button on bottom right corner})
	(FrameOut)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(temp0 dispose:)
	)
	(temp0 localize: global116)
	(= temp6 (temp0 y:))
	(= temp5 (temp0 x:))
	(temp0 dispose:)
	(= temp1 (+ (/ (- temp5 temp3) 2) temp3))
	(= temp2 (+ (/ (- temp6 temp4) 2) temp4))
	(param1
		x: temp1
		y: temp2
		nsTop: temp4
		nsLeft: temp3
		nsRight: temp5
		nsBottom: temp6
	)
)

(procedure (localproc_1 param1)
	(local4 name: gSysLogPath writeString: param1 close:)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3)
	(= local5 (Str format: {,\r\n\t\t\tsetPolygon:\r\n}))
	(repeat
		(FrameOut)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
			(temp0 dispose:)
		)
		(if (& (temp0 modifiers:) emSHIFT)
			((Sound new:) number: 4002 play:)
		else
			((Sound new:) number: 4000 play:)
			(temp0 localize: global116)
			(= temp1 (Str format: {%d %d } (temp0 x:) (temp0 y:)))
		)
		(temp0 dispose:)
		(repeat
			(if (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
				(temp0 dispose:)
			else
				(if (& (temp0 modifiers:) emSHIFT)
					((Sound new:) number: 4002 play:)
					(break)
				else
					((Sound new:) number: 4000 play:)
					(temp0 localize: global116)
					(temp1
						cat:
							(= temp2
								(Str format: {%d %d } (temp0 x:) (temp0 y:))
							)
					)
					(temp2 dispose:)
				)
				(temp0 dispose:)
			)
		)
		(local5
			cat:
				(= temp3
					(Str
						format:
							{\t\t\t\t((Polygon new:)\r\n\t\t\t\t\ttype:PTotalAccess,\r\n\t\t\t\t\tinit:\r\n\t\t\t\t\t%s,\r\n\t\t\t\t\tyourself?\r\n\t\t\t\t)\r\n}
							temp1
					)
				)
		)
		(temp3 dispose:)
		(if
			(not
				(Print
					addText: {Another?}
					addButton: 1 {Another} 0 18
					addButton: 0 {NoMore} 80 18
					init:
				)
			)
			(break)
		)
	)
)

(class Class_64948_0
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (Str new:))
		(if (not local3)
			(temp0 format: {%d.fea} gCurRoomNum)
			(gSysLogPath cat: temp0)
		)
		(= temp1 (Feature new:))
		(= local0 (Str new:))
		(= local1 (Str new:))
		(GetInput local0 15 {Name?})
		(GetInput local1 15 {Noun?})
		(if
			(= local2
				(Print
					addText: {Rect or Poly?}
					addButton: 1 {RECT} 1 12
					addButton: 0 {POLY} 50 12
					init:
				)
			)
			(localproc_0 temp1)
			(= local5 (Str format: {\r\n}))
		else
			(localproc_2)
		)
		(Class_64948_1 doit: temp1)
	)
)

(class Class_64948_1
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 4] temp11 temp12 temp13)
		(= temp6 (Str new:))
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(= temp3 (Str new:))
		(if (FileIO fiEXISTS (gSysLogPath data:))
			(temp6 format: {The file '%s' already exists} gSysLogPath)
			(if
				(or
					(==
						(= temp5
							(Print
								addText: temp6
								addButton: 1 {Replace} 0 20
								addButton: 2 {Append} 73 20
								addButton: 0 {Cancel} 133 20
								init:
							)
						)
						-1
					)
					(not temp5)
				)
				(return 0)
			)
		)
		(= temp4 (if (== temp5 1) 2 else 0))
		(if (not ((= local4 (File new:)) name: (gSysLogPath data:) open: temp4))
			(temp0 format: {Error opening '%s'} gSysLogPath)
			(Prints temp0)
			(local4 dispose:)
			(return 0)
		)
		(if (param1 isMemberOf: Feature)
			(if local2
				(temp1
					format:
						{ \t\tnsLeft\t\t\t%d\r\n\t\tnsTop\t\t\t\t%d\r\n\t\tnsRight\t\t\t%d\r\n\t\tnsBottom\t\t\t%d\r\n}
						(param1 nsLeft:)
						(param1 nsTop:)
						(param1 nsRight:)
						(param1 nsBottom:)
				)
			else
				(temp1 with: {})
			)
		)
		(= temp11 (Feature new:))
		(temp11
			init:
			name: (local0 data:)
			nsLeft: (param1 nsLeft:)
			nsTop: (param1 nsTop:)
			nsRight: (param1 nsRight:)
			nsBottom: (param1 nsBottom:)
			x: (param1 x:)
			y: (param1 y:)
			z: (param1 z:)
		)
		(= temp2
			(switch ((gCurRoom picObj:) angle:)
				(-1
					(Str with: {})
				)
				(0
					(Str with: {})
				)
				(90
					(Str with: {_up})
				)
				(-90
					(Str with: {_down})
				)
			)
		)
		(= temp13 (param1 getSuper:))
		(temp0
			format:
				{ \r\n(instance %s_%d%s of %s\r\n\t(properties\r\n\t\tx\t\t\t\t\t%d\r\n\t\ty\t\t\t\t\t%d\r\n\t\tz\t\t\t\t\t%d\r\n%s \t\tnoun\t\t\t\t%s\r\n\t)\r\n\r\n\t(method (init)\r\n\t\t(super init:&rest)\r\n\t\t(self\r\n\t\t\tsetHotspot:COMPUTE_V%s \t\t)\r\n\t)\r\n)\r\n}
				local0
				(gCurRoom heading:)
				temp2
				(temp13 name:)
				(param1 x:)
				(param1 y:)
				(param1 z:)
				temp1
				local1
				local5
		)
		(localproc_1 temp0)
		(if (param1 isMemberOf: Feature)
			(param1 dispose:)
		)
		(local4 close: dispose:)
		(local0 dispose:)
		(temp2 dispose:)
		(temp1 dispose:)
		(local1 dispose:)
		(local5 dispose:)
		(gSysLogPath format: {})
		(DisposeScript 64993)
		(return (DisposeScript 64948))
	)

	(method (writeList param1)
		(param1 eachElementDo: #perform self)
		(Class_64948_0 doit:)
		(DisposeScript 64948)
	)
)

(instance shmFile of File ; UNUSED
	(properties)
)

(instance sEndSnd of Sound ; UNUSED
	(properties
		number 4002
	)
)

(instance sOKSnd of Sound ; UNUSED
	(properties
		number 4000
	)
)

