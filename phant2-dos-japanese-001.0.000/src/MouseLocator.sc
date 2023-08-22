;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64959)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use TextField)

(class MouseLocator of TextView
	(properties
		client 0
		back 4
		borderColor 4
		textLeft 2
		textTop 3
		celHeight 14
		celWidth 61
		skip 1
	)

	(method (init)
		(self needsDoits: 0)
		((gUser primaDonnas:) add: self)
		(= plane (Plane new:))
		(plane
			picture: -2
			setPri: (+ 1 (GetHighPlanePri))
			init: 0 (- gLastScreenY celHeight) 75 gLastScreenY
		)
		(|= signal $0008)
		(self setPri: 255)
	)

	(method (dispose)
		(if (not (& signal $0008))
			(if (!= self ((gUser hogs:) peek:))
				(PrintDebug {MouseLoc not at top of hogs!\n})
				(SetDebug (gUser hogs:))
			)
			((gUser hogs:) pop:)
			(self hide:)
		)
		((plane cast:) delete: self)
		(plane dispose:)
		((gUser primaDonnas:) delete: self)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(if text
			(KArray 4 text) ; ArrayFree
		)
		(= plane (= text (= bitmap 0)))
		(DisposeClone self)
	)

	(method (handleEvent event)
		(cond
			((not (& signal $0008))
				(if (gUser mouseMoved:)
					(self update:)
				)
				(if (and (& evMOUSERELEASE (event type:)) (& emSHIFT (event modifiers:)))
					((gUser hogs:) pop:)
					(self hide:)
				)
				(event claimed: self)
				(return)
			)
			((and (& evMOUSEBUTTON (event type:)) (& emSHIFT (event modifiers:)))
				(event claimed: self)
				((gUser hogs:) push: self 0)
				(self show:)
			)
		)
		(event claimed:)
	)

	(method (onMe)
		(return 0)
	)

	(method (show)
		(if (& signal $0008)
			(self update: 0)
			(super show:)
		)
	)

	(method (update param1 &tmp temp0 temp1 temp2)
		(= celWidth 61)
		(= temp1 gMouseX)
		(= temp2 gMouseY)
		(if client
			(= celWidth 75)
			(-= temp1 (client left:))
			(-= temp2 (client top:))
		)
		(= temp0 (Str format: {%d/%d} temp1 temp2))
		(self setText: temp0)
		(temp0 dispose:)
		(self setSize:)
		(self draw:)
		(if (plane onMe: gMouseX gMouseY)
			(if (plane left:)
				(plane setRect: 0 (plane top:) 75 (plane bottom:) 1)
			else
				(plane
					setRect:
						(- gLastScreenX 75)
						(plane top:)
						gLastScreenX
						(plane bottom:)
						1
				)
			)
		)
		(if (or (not argc) param1)
			(UpdateScreenItem self)
			(self setRect:)
		)
	)
)

