;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 705)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use GameControls)
(use System)

(public
	askFire 0
)

(local
	local0
)

(instance askFire of Code
	(properties)

	(method (init param1 param2 param3 &tmp temp0)
		((= local0 (GameControls new:))
			window:
				((GloryWindow new:)
					top: 40
					left: (proc0_21 65 65 65 45 65)
					bottom: 80
					right: (proc0_21 256 256 256 276 256)
					priority: 15
					yourself:
				)
		)
		(= temp0 (fireIcon new: param1 param2 param3 1))
		(temp0
			view: 935
			loop: 1
			cel: 0
			nsTop: 2
			nsLeft: (proc0_21 2 2 2 22 2)
			modifiers: 1
		)
		(local0 add: temp0)
		(= temp0 (fireIcon new: param1 param2 param3 2))
		(temp0 nsTop: 25 nsLeft: 5 cursor: 1)
		(local0 add: temp0)
		(= temp0 (fireIcon new: param1 param2 param3 3))
		(temp0 nsTop: 25 nsLeft: (proc0_21 95 95 95 115 95) cursor: 2)
		(local0 add: temp0)
		(local0 init: show: dispose:)
		(= local0 0)
	)
)

(instance fireIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
	)

	(method (new param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(= temp0 (Clone self))
		(if argc
			(= temp1 (Message msgSIZE gCurRoomNum param1 param2 param3 param4))
			(temp0 message: (Memory memALLOC_NONCRIT temp1))
			(Message msgGET gCurRoomNum param1 param2 param3 param4 (temp0 message:))
		)
		(return temp0)
	)

	(method (show)
		(= nsRight
			(+
				nsLeft
				(if (== loop 1)
					0
				else
					(+ (proc0_21 70 70 70 110 70) 20)
				)
			)
		)
		(= nsBottom
			(if (== loop 1)
				nsTop
			else
				(+ nsTop 15)
			)
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display
			message
			dsCOORD
			(if (== loop 1)
				nsLeft
			else
				(+ nsLeft 20)
			)
			(+ nsTop 2)
			dsFONT
			(if (== loop 1)
				(proc0_21 310 310 310 310 123)
			else
				0
			)
			dsCOLOR
			17
			dsALIGN
			modifiers
			dsWIDTH
			(if (== loop 1)
				189
			else
				(proc0_21 70 70 70 110 70)
			)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (!= loop 1)
			(if param1
				(DrawCel view loop 1 nsLeft nsTop -1)
				(= temp0 46)
			else
				(DrawCel view loop 0 nsLeft nsTop -1)
				(= temp0 17)
			)
			(Display
				message
				dsCOORD
				(if (== loop 1)
					nsLeft
				else
					(+ nsLeft 20)
				)
				(+ nsTop 2)
				dsFONT
				(if (== loop 1)
					(proc0_21 310 310 310 310 123)
				else
					0
				)
				dsCOLOR
				temp0
				dsALIGN
				modifiers
				dsWIDTH
				(if (== loop 1)
					189
				else
					(proc0_21 70 70 70 110 70)
				)
			)
		)
	)

	(method (select)
		(if (!= loop 1)
			(= global460 cursor)
			(local0 state: (& (local0 state:) $ffdf))
		else
			(return 0)
		)
	)

	(method (dispose)
		(Memory memFREE message)
		(super dispose:)
	)
)

