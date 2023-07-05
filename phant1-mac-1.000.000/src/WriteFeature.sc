;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64948)
(include sci.sh)
(use Main)
(use Interface)
(use Str)
(use Print)
(use Polygon)
(use Feature)
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
	local6
)

(procedure (localproc_0 param1) ; UNUSED
	(param1 sightAngle: (GetNumber {sight angle?} 40))
	(param1 modNum: (GetNumber {Mod Number?} 0))
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(Prints {Click left mouse button on top left corner})
	(FrameOut)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(temp0 dispose:)
	)
	(temp0 localize: (gCast plane:))
	(= temp4 (temp0 y:))
	(= temp3 (temp0 x:))
	(temp0 dispose:)
	(Prints {Click left mouse button on bottom right corner})
	(FrameOut)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(temp0 dispose:)
	)
	(temp0 localize: (gCast plane:))
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
	(= local6 (List new:))
	(local6
		add:
			((Polygon new:)
				type: PContainedAccess
				init: temp3 temp4 temp5 temp4 temp5 temp6 temp3 temp6
				yourself:
			)
	)
	(AddPolygon (gCast plane:) local6 300 255 0 0 1 1)
	(local6 dispose:)
)

(procedure (localproc_2 param1 &tmp temp0)
	(param1
		view: (GetNumber {View?} (gCurRoom curPic:))
		loop: (GetNumber {Loop?} 0)
		cel: (GetNumber {Cel?} 0)
		x: (gEgo x:)
		y: (gEgo y:)
		signal: 16417
	)
	(gEgo view: (param1 view:) loop: (param1 loop:) cel: (param1 cel:))
	(UpdateScreenItem gEgo)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2 [temp3 4])
	(if
		(Print
			addText: {Where should the approach point be?}
			addButton: 1 {Select with mouse} 0 20
			addButton: 0 {Default to objects x, y} 0 44
			init:
		)
		(FrameOut)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
			(temp0 dispose:)
		)
		(temp0 localize: (gCast plane:))
		(param1 approachX: (= temp1 (temp0 x:)) approachY: (= temp2 (temp0 y:)))
		(temp0 dispose:)
		(AddLine
			(gCast plane:)
			(- temp1 1)
			(- temp2 1)
			(+ temp1 1)
			(- temp2 1)
			100
			7
			0
			0
			1
		)
		(AddLine
			(gCast plane:)
			(- temp1 1)
			temp2
			(+ temp1 1)
			temp2
			100
			7
			0
			0
			1
		)
		(AddLine
			(gCast plane:)
			(- temp1 1)
			(+ temp2 1)
			(+ temp1 1)
			(+ temp2 1)
			100
			7
			0
			0
			1
		)
		(AddLine (gCast plane:) temp1 temp2 temp1 temp2 100 0 0 0 1)
	else
		(param1 approachX: (param1 x:) approachY: (param1 y:))
	)
)

(procedure (localproc_4 param1)
	(local5 name: gSysLogPath writeString: param1 close:)
)

(class Class_64948_0
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (Str new:))
		(if (not local3)
			(temp0 format: {%d.fea} (gCurRoom picture:))
			(if (not (GetInput temp0 30 {Enter path and filename.}))
				(return)
			else
				(gSysLogPath cat: temp0)
				(= local3 1)
			)
		)
		(if (not (= local4 Feature))
			(return)
		)
		(= temp1 (local4 new:))
		(= local0 (Str new:))
		(GetInput local0 30 {Name?})
		(if (== local4 Feature)
			(if
				(= local2
					(Print
						addText: {Outline Features?}
						addTitle: {Feature Write V2.0}
						addButton: 1 {YES} 0 12
						addButton: 0 {NO} 50 12
						init:
					)
				)
				(localproc_1 temp1)
			)
		else
			(localproc_2 temp1)
		)
		(localproc_3 temp1)
		(if
			(Print
				addText: {Z property}
				addTitle: {Feature Writer V2.0}
				addButton: 1 {YES} 0 12
				addButton: 0 {NO} 50 12
				init:
			)
			(Print
				addText: {Click mouse on object's projection}
				addText: {onto the ground} 0 12
				init:
			)
			(FrameOut)
			(while (!= ((= temp2 (Event new:)) type:) evMOUSEBUTTON)
				(temp2 dispose:)
			)
			(temp2 localize: (gCast plane:))
			(temp1 z: (- (temp2 y:) (temp1 y:)))
			(temp1 y: (temp2 y:))
			(temp2 dispose:)
		)
		(Class_64948_1 doit: temp1)
	)
)

(class Class_64948_1
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 4] temp10 temp11)
		(= temp5 (Str new:))
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(= temp2 (Str new:))
		(if (FileIO fiEXISTS (gSysLogPath data:))
			(temp5 format: {The file '%s' already exists} gSysLogPath)
			(if
				(not
					(= temp4
						(Print
							addText: temp5
							addButton: 1 {Replace} 0 20
							addButton: 2 {Append} 73 20
							addButton: 0 {Cancel} 133 20
							init:
						)
					)
				)
				(return 0)
			)
		)
		(= temp3 (if (== temp4 1) 2 else 0))
		(if (not ((= local5 (File new:)) name: (gSysLogPath data:) open: temp3))
			(temp0 format: {Error opening '%s'} gSysLogPath)
			(Prints temp0)
			(local5 dispose:)
			(return 0)
		)
		(if (param1 isMemberOf: Feature)
			(temp1
				format:
					{ \t\tnsLeft\t\t\t%d\r\n\t\tnsTop\t\t\t\t%d\r\n\t\tnsRight\t\t\t%d\r\n\t\tnsBottom\t\t\t%d\r\n}
					(param1 nsLeft:)
					(param1 nsTop:)
					(param1 nsRight:)
					(param1 nsBottom:)
			)
			(= temp10 (Feature new:))
			(temp10
				init:
				name: (local0 data:)
				nsLeft: (param1 nsLeft:)
				nsTop: (param1 nsTop:)
				nsRight: (param1 nsRight:)
				nsBottom: (param1 nsBottom:)
				x: (param1 x:)
				y: (param1 y:)
				z: (param1 z:)
				approachX: (param1 approachX:)
				approachY: (param1 approachY:)
			)
		else
			(temp1
				format:
					{ \t\tview\t\t\t%d\r\n\t\tloop\t\t\t%d\r\n\t\tcel\t\t\t%d\r\n}
					(param1 view:)
					(param1 loop:)
					(param1 cel:)
			)
		)
		(temp2
			format:
				{ \t\tapproachX\t\t%d\r\n\t\tapproachY\t\t%d\r\n}
				(param1 approachX:)
				(param1 approachY:)
		)
		(temp0
			format:
				{ \r\n(instance %s of %s\r\n\t(properties\r\n\t\tx\t\t\t\t\t%d\r\n\t\ty\t\t\t\t\t%d\r\n\t\tz\t\t\t\t\t%d\r\n%s %s \t)\r\n)\r\n}
				local0
				((param1 -super-:) name:)
				(param1 x:)
				(param1 y:)
				(param1 z:)
				temp1
				temp2
		)
		(localproc_4 temp0)
		(if (param1 isMemberOf: Feature)
			(param1 dispose:)
		)
		(local5 close: dispose:)
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

