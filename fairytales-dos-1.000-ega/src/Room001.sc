;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Interface)
(use GameControls)
(use IconBar)
(use LoadMany)
(use Window)
(use Game)
(use System)

(public
	Room001 0
)

(local
	local0
	local1
	local2
	local3
	[local4 26] = [{A} {B} {C} {D} {E} {F} {G} {H} {I} {J} {K} {L} {M} {N} {O} {P} {Q} {R} {S} {T} {U} {V} {W} {X} {Y} {Z}]
	[local30 26]
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (CelWide (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp2 (CelHigh (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp1 (+ (param1 nsLeft:) (/ temp0 2)))
	(= temp3 (- (+ (param1 nsTop:) temp2) 1))
	(gGame setCursor: gTheCursor 1 temp1 temp3)
)

(procedure (localproc_1)
	(Display @global110 dsCOORD 120 0 dsFONT gUserFont dsCOLOR (proc10_30 14 2))
	(= local0 (proc10_24 gUserFont @global110))
	(Graph grDRAW_LINE 13 120 13 (+ local0 120) (proc10_30 64 4) -1 -1)
	(Graph grUPDATE_BOX 12 120 14 (+ local0 120) 1)
)

(instance Room001 of Rm
	(properties
		picture 1
	)

	(method (init)
		(LoadMany rsVIEW 90 101 102)
		(gTheIconBar disable: hide:)
		(SetPort 0 0 200 320 0 0)
		(super init: &rest)
		(gCurRoom setScript: selectSelf)
	)
)

(instance selectSelf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 80 1 165 130)
				(= [global110 0] 0)
				(proc10_15)
				(egoControls init: show:)
				(gCurRoom picture: 0)
				(DrawPic 1 100 1 global40)
				(Graph grUPDATE_BOX 0 0 0 320 1)
				(proc10_15)
				(gGame setCursor: 80)
				(proc10_15)
				(DrawCel 90 0 0 41 6 15)
				(Graph grUPDATE_BOX 6 41 29 279 1)
				(alphabet init: show:)
				(= cycles 1)
				(egoControls dispose:)
				(alphabet dispose:)
				(DrawPic 802 100 1 global40)
				(Graph grFILL_BOX 0 0 26 320 1 0 -1 -1)
				(Graph grUPDATE_BOX 0 0 26 320 1)
				(SetPort 0 0 174 320 26 0)
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 80 15 12 0)
				)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance egoControls of GameControls
	(properties
		stopSound 0
	)

	(method (init)
		(self
			add: iconEgo0 iconEgo1 iconEgo2 iconEgo3 iconEgo4 iconEgo5
			eachElementDo: #init
			eachElementDo: #highlightColor (proc10_30 5 31)
			eachElementDo: #lowlightColor (proc10_30 36 1)
		)
		(super init: &rest)
		(= window egoWindow)
		(self add: ((dummyIcon new:) nsRight: 518 nsBottom: 163 yourself:))
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(if (and (& (event type:) $0040) (IsObject highlightedIcon)) ; direction
			(= temp0 (self indexOf: highlightedIcon))
			(switch (event message:)
				(JOY_DOWN
					(if (< temp0 3)
						(= temp1 (self at: (+ temp0 3)))
					else
						(= temp1 (self at: (- temp0 3)))
					)
					(localproc_0 temp1)
					(self highlight: temp1)
				)
				(JOY_UP
					(if (< temp0 3)
						(= temp1 (self at: (+ temp0 3)))
					else
						(= temp1 (self at: (- temp0 3)))
					)
					(localproc_0 temp1)
					(self highlight: temp1)
				)
			)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event message: JOY_NULL)
		)
		(super dispatchEvent: event)
	)

	(method (advance)
		(super advance: &rest)
		(if (== (highlightedIcon name:) {dummyIcon})
			(super advance:)
		)
	)

	(method (retreat)
		(super retreat: &rest)
		(if (== (highlightedIcon name:) {dummyIcon})
			(super retreat:)
		)
	)
)

(instance alphabet of GameControls
	(properties
		stopSound 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(= window letterWindow)
		(letterWindow back: (proc10_30 36 1))
		(= temp4 (- (window right:) (window left:)))
		(= temp3 49)
		(= temp2 34)
		(for ((= temp0 0)) (<= temp0 8) ((++ temp0))
			(= [local30 temp0]
				(= temp1
					((letter new:)
						view: 101
						loop: (+ 3 temp0)
						cel: 0
						nsLeft: temp2
						nsTop: temp3
						nsRight: (+ temp2 25)
						nsBottom: (+ temp3 19)
						value: temp0
					)
				)
			)
			(self add: temp1)
			(+= temp2 28)
		)
		(= temp2 47)
		(= temp3 69)
		(for ((= temp0 9)) (<= temp0 12) ((++ temp0))
			(= [local30 temp0]
				(= temp1
					((letter new:)
						view: 101
						loop: (+ 3 temp0)
						cel: 0
						nsLeft: temp2
						nsTop: temp3
						value: temp0
					)
				)
			)
			(self add: temp1)
			(+= temp2 28)
		)
		(for ((= temp0 13)) (<= temp0 16) ((++ temp0))
			(= [local30 temp0]
				(= temp1
					((letter new:)
						view: 102
						loop: (- temp0 13)
						cel: 0
						nsLeft: temp2
						nsTop: temp3
						value: temp0
					)
				)
			)
			(self add: temp1)
			(+= temp2 28)
		)
		(= temp2 34)
		(= temp3 89)
		(for ((= temp0 17)) (<= temp0 25) ((++ temp0))
			(= [local30 temp0]
				(= temp1
					((letter new:)
						view: 102
						loop: (- temp0 13)
						cel: 0
						nsLeft: temp2
						nsTop: temp3
						value: temp0
					)
				)
			)
			(self add: temp1)
			(+= temp2 28)
		)
		(self
			add: iconBack iconForward iconOk
			eachElementDo: #highlightColor (proc10_30 5 31)
			eachElementDo: #lowlightColor (proc10_30 36 1)
		)
		(super init: &rest)
		(self add: (dummyIcon nsRight: 517 nsBottom: 150 yourself:))
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== (= temp0 (event type:)) evKEYBOARD)
			(if
				(or
					(and (>= (= temp1 (event message:)) KEY_a) (<= temp1 KEY_z))
					(and (>= temp1 KEY_A) (<= temp1 KEY_Z))
				)
				(if (and (>= temp1 KEY_A) (<= temp1 KEY_Z))
					(= temp1 (+ (- temp1 65) 97))
				)
				([local30 (- temp1 97)] highlight: select:)
				(= local3 1)
			else
				(switch temp1
					(JOY_UPLEFT
						(iconBack select:)
					)
					(KEY_SPACE
						(iconForward select:)
					)
					(KEY_RETURN
						(if local3
							(event claimed: 1 message: JOY_NULL)
							(iconOk select:)
						)
					)
				)
			)
		)
		(if (and (& temp0 $0040) (IsObject highlightedIcon)) ; direction
			(= temp3 (self indexOf: highlightedIcon))
			(switch (event message:)
				(JOY_DOWN
					(if (== (highlightedIcon name:) {letter})
						(cond
							((< temp3 8)
								(= temp4 (self at: (+ temp3 9)))
							)
							((< temp3 9)
								(= temp4 (self at: (+ temp3 8)))
							)
							((< temp3 17)
								(= temp4 (self at: (+ temp3 9)))
							)
							((< temp3 26)
								(= temp4 (self at: (- size 3)))
							)
						)
					else
						(= temp4 (self at: (- temp3 23)))
					)
					(localproc_0 temp4)
					(self highlight: temp4)
				)
				(JOY_UP
					(if (== (highlightedIcon name:) {letter})
						(cond
							((< temp3 9)
								(= temp4 (self at: (- size 3)))
							)
							((< temp3 17)
								(= temp4 (self at: (- temp3 9)))
							)
							((< temp3 25)
								(= temp4 (self at: (- temp3 8)))
							)
							((< temp3 26)
								(= temp4 (self at: (- temp3 9)))
							)
						)
					else
						(= temp4 (self at: (- temp3 6)))
					)
					(localproc_0 temp4)
					(self highlight: temp4)
				)
			)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event message: JOY_NULL)
		)
		(super dispatchEvent: event)
	)

	(method (advance)
		(super advance: &rest)
		(if (== (highlightedIcon name:) {dummyIcon})
			(super advance:)
		)
	)

	(method (retreat)
		(super retreat: &rest)
		(if (== (highlightedIcon name:) {dummyIcon})
			(super retreat:)
		)
	)
)

(instance egoWindow of SysWindow
	(properties
		top 36
		bottom 199
		right 518
		color 15
		type 129
	)

	(method (open)
		(super open:)
	)
)

(instance dummyIcon of IconI
	(properties)

	(method (highlight))

	(method (select))

	(method (show))
)

(instance letterWindow of SysWindow
	(properties
		top 50
		bottom 200
		right 517
		type 129
	)

	(method (open)
		(super open:)
	)
)

(instance iconEgo0 of CodeIcon
	(properties
		view 16
		loop 0
		cel 0
		nsLeft 40
		nsTop 0
		cursor 80
		helpStr {This icon is for selecting an ego.}
	)

	(method (select)
		(if (super select: &rest)
			(= global139 0)
			(egoControls hide:)
		)
	)
)

(instance iconEgo1 of CodeIcon
	(properties
		view 16
		loop 1
		cel 0
		nsLeft 132
		nsTop 0
		cursor 80
		helpStr {This icon is for selecting an ego.}
	)

	(method (select)
		(if (super select: &rest)
			(= global139 1)
			(egoControls hide:)
		)
	)
)

(instance iconEgo2 of CodeIcon
	(properties
		view 16
		loop 2
		cel 0
		nsLeft 224
		nsTop 0
		cursor 80
		helpStr {This icon is for selecting an ego.}
	)

	(method (select)
		(if (super select: &rest)
			(= global139 2)
			(egoControls hide:)
		)
	)
)

(instance iconEgo3 of CodeIcon
	(properties
		view 16
		loop 3
		cel 0
		nsLeft 40
		nsTop 64
		cursor 80
		helpStr {This icon is for selecting an ego.}
	)

	(method (select)
		(if (super select: &rest)
			(= global139 3)
			(egoControls hide:)
		)
	)
)

(instance iconEgo4 of CodeIcon
	(properties
		view 16
		loop 4
		cel 0
		nsLeft 132
		nsTop 64
		cursor 80
		helpStr {This icon is for selecting an ego.}
	)

	(method (select)
		(if (super select: &rest)
			(= global139 4)
			(egoControls hide:)
		)
	)
)

(instance iconEgo5 of CodeIcon
	(properties
		view 16
		loop 5
		cel 0
		nsLeft 224
		nsTop 64
		cursor 80
		helpStr {This icon is for selecting an ego.}
	)

	(method (select)
		(if (super select: &rest)
			(= global139 5)
			(egoControls hide:)
		)
	)
)

(instance iconOk of CodeIcon
	(properties
		view 101
		loop 2
		cel 0
		nsLeft 185
		nsTop 25
		signal 193
	)

	(method (select)
		(if (== (StrLen @global110) 0)
			(Print 1 0) ; "Please write your name."
			(return 0)
		else
			(return (super select: &rest))
		)
	)
)

(instance letter of CodeIcon
	(properties
		loop 0
		cel 0
		helpStr {This is a letter to help write your name.}
	)

	(method (select)
		(if (and (super select: &rest) (<= local1 9))
			(if
				(or
					(== (StrLen @global110) 0)
					(== (StrAt @global110 (- local1 1)) 32)
				)
				(StrAt @global110 local1 (+ 65 value))
			else
				(StrAt @global110 local1 (+ 97 value))
			)
			(localproc_1)
			(++ local1)
		)
	)
)

(instance iconBack of CodeIcon
	(properties
		view 101
		loop 0
		cel 0
		nsLeft 85
		nsTop 25
	)

	(method (select)
		(if (super select: &rest)
			(Graph grDRAW_LINE 13 120 13 230 (proc10_30 36 1) -1 -1)
			(Graph grUPDATE_BOX 12 120 14 190 1)
			(Display @global110 dsCOORD 120 0 dsFONT gUserFont dsCOLOR (letterWindow back:))
			(if local1
				(-- local1)
			)
			(StrAt @global110 local1 0)
			(localproc_1)
		)
	)
)

(instance iconForward of CodeIcon
	(properties
		view 101
		loop 1
		cel 0
		nsLeft 135
		nsTop 25
	)

	(method (select)
		(if (and (super select: &rest) (< local1 9))
			(StrAt @global110 local1 32)
			(++ local1)
			(localproc_1)
		)
	)
)

