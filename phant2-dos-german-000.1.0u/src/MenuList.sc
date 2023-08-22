;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62997)
(include sci.sh)
(use Main)
(use Array)
(use WriteFeature)
(use Flags)
(use TextField)
(use Menu)

(class MenuList of List
	(properties
		back 3
		manager 0
		noun -1
		modNum -1
		flags 0
		fore 22
		font 7001
		width -1
	)

	(method (new param1 param2 &tmp temp0)
		(= temp0 (super new:))
		(if argc
			(temp0 manager: param1)
			(if (> argc 1)
				(temp0 flags: param2)
			)
		)
		(return temp0)
	)

	(method (init param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3)
		(super init:)
		(= temp3 (manager lineHeight:))
		(= width param4)
		(if (> argc 4)
			(= modNum param5)
			(if (> argc 4)
				(= noun param6)
			)
		)
		(= temp0 1)
		(= temp2 param3)
		(while (< temp0 255)
			(if (and (Message msgGET modNum noun 0 temp0 1) (self validate: temp0))
				((= temp1 (param1 new:))
					setText: modNum noun 0 temp0 1
					setSize: self
					posn: param2 temp2
				)
				(+= temp2 (temp1 celHeight:))
				(self addToEnd: temp1)
			)
			(++ temp0)
		)
		(if (not size)
			((= temp1 (SelectItem new:))
				setText: 1000 0 0 0 1
				setSize: self
				posn: param2 param3
				case: 0
			)
			(self add: temp1)
		)
	)

	(method (dispose)
		(= manager (= flags 0))
		(super dispose:)
	)

	(method (validate param1)
		(return
			(if flags
				(flags test: param1)
			else
				1
			)
		)
	)
)

(class SelectItem of TextView
	(properties
		back -1
		textLeft 14
		lineHeight -1
		numLines -1
		maskLines 0
		mask 0
		manager 0
		case -1
		bulletView 4020
		bulletLoop 11
		fore -1
	)

	(method (init param1)
		(self draw:)
		(= plane
			(cond
				(argc param1)
				(plane plane)
				(else gThePlane)
			)
		)
		((plane cast:) add: self)
	)

	(method (draw param1 &tmp temp0 temp1 temp2 temp3)
		(if (not (not (& state $0002)))
			(= borderColor fore)
			(text fore: back back: borderColor)
		else
			(= borderColor back)
			(text fore: fore back: borderColor)
		)
		(super draw:)
		(if bulletView
			(Bitmap 3 bitmap bulletView bulletLoop 0 0 0) ; AddCel
		)
		(if maskLines
			(= temp0 (text skip:))
			(= temp3 (manager width:))
			(-- temp3)
			(if (< maskLines 0)
				(= temp1 0)
				(= temp2 (* -1 maskLines lineHeight))
				(-- temp2)
			else
				(= temp2 (* lineHeight numLines))
				(= temp1 (- (-- temp2) (* maskLines lineHeight)))
				(++ temp1)
			)
			(Bitmap 5 bitmap 0 temp1 temp3 temp2 temp0) ; AddRect
		)
		(if (and argc param1)
			(self update:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((and responder (responder handleEvent: event &rest))
				(return 1)
			)
			((& (event type:) evMOUSERELEASE)
				(= temp1
					(if (= temp0 (manager flags:))
						(temp0 getVMD: case)
					else
						-1
					)
				)
				(plane done: temp1)
			)
		)
	)

	(method (hilite param1)
		(if (and argc (^ param1 (not (not (& state $0002)))))
			(if param1
				(|= state $0002)
			else
				(&= state $fffd)
			)
			(self draw: 1)
		)
		(return (not (not (& state $0002))))
	)

	(method (setText param1)
		(if (not text)
			(= text (itemTextField new:))
		)
		(if (> argc 1)
			(= case [param1 3])
		)
		(super setText: param1 &rest)
	)

	(method (setSize param1)
		(= manager param1)
		(= borderColor (manager back:))
		(= celWidth (param1 width:))
		(= lineHeight ((param1 manager:) lineHeight:))
		(= fore (param1 fore:))
		(= back (param1 back:))
		(text
			font: (param1 font:)
			fore: fore
			back: back
			width: (- (param1 width:) 14)
		)
		(super setSize:)
		(= numLines (/ celHeight lineHeight))
	)

	(method (show)
		(if mask
			(= mask 0)
			(self draw:)
		)
		(super show:)
	)

	(method (update)
		(if mask
			(= mask 0)
			(self draw:)
		)
		(super update: &rest)
	)
)

(instance itemTextField of TextField
	(properties)

	(method (read &tmp [temp0 2])
		(-- width)
		(super read: &rest)
	)
)

(class VMultiLineSelector of Obj
	(properties
		scrollBar 0
		items 0
		pageSize 0
		lineHeight -1
		topLineNum -1
		numLines -1
		curItem 0
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (= numLines 0))
		(= temp1 (items size:))
		(while (< temp0 temp1)
			(+= numLines ((items at: temp0) numLines:))
			(++ temp0)
		)
	)

	(method (dispose)
		(if scrollBar
			(scrollBar dispose:)
			(= scrollBar 0)
		)
		(items dispose:)
		(= curItem (= items 0))
		(super dispose:)
	)

	(method (cue param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp1 (- topLineNum param1))
		(= temp0 (* lineHeight temp1))
		(= temp6 (+ param1 pageSize -1))
		(= temp2 (items first:))
		(for ((= temp7 0)) temp2 ((= temp7 (+ temp8 1)))
			(= temp3 (items value: temp2))
			(= temp8 (+ temp7 (temp3 numLines:) -1))
			(= temp4 (temp3 y:))
			(temp3 y: (+ temp4 temp0))
			(if (or (< temp8 param1) (> temp7 temp6))
				(temp3 hide:)
			else
				(if
					(and
						(>= (= temp9 (- temp7 param1)) 0)
						(< (= temp9 (- temp8 temp6)) 0)
					)
					(= temp9 0)
				)
				(if (!= temp9 (temp3 maskLines:))
					(temp3 mask: 1 maskLines: temp9)
				)
				(if (temp3 isVisible:)
					(temp3 update:)
				else
					(temp3 show:)
				)
			)
			(= temp2 (items next: temp2))
		)
		(= topLineNum param1)
	)

	(method (doit param1 param2)
		(cond
			((== argc 2)
				(if curItem
					(if (curItem onMe: param1 param2)
						(return)
					else
						(curItem hilite: 0)
						(= curItem 0)
					)
				)
				(= curItem (items firstTrue: #onMe param1 param2))
				(if curItem
					(curItem hilite: 1)
				)
			)
			(curItem
				(curItem hilite: 0)
				(= curItem 0)
			)
		)
	)
)

(class VMDTable of Flags
	(properties
		vmdNumbers 0
	)

	(method (init param1)
		(= size (if argc param1 else 256))
		(if array
			(array dispose:)
			(= array 0)
		)
		(= vmdNumbers (IntArray new: size))
		(vmdNumbers fill: 0 size -1)
		(super init:)
	)

	(method (dispose)
		(SetDebug)
		(if vmdNumbers
			(vmdNumbers dispose:)
			(= vmdNumbers 0)
		)
		(super dispose:)
	)

	(method (add param1 param2 &tmp temp0 temp1)
		(while argc
			(= temp0 [param1 (-= argc 2)])
			(= temp1 [param2 argc])
			(vmdNumbers at: temp0 temp1)
		)
	)

	(method (getVMD param1)
		(vmdNumbers at: param1)
	)

	(method (lookUp param1)
		(vmdNumbers indexOf: param1)
	)
)

