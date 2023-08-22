;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64996)
(include sci.sh)
(use Main)
(use WriteFeature)
(use Menu)

(class Event of Obj
	(properties
		plane 0
		type 0
		x 0
		y 0
		message 0
		modifiers 0
		claimed 0
		mask 32767
	)

	(method (new param1 &tmp temp0)
		(= temp0
			(if (self isClass:)
				(Clone self)
			else
				self
			)
		)
		(if argc
			(temp0 mask: param1)
		)
		(temp0 init:)
	)

	(method (init param1)
		(if argc
			(= mask param1)
		)
		(= plane (= type (= message (= modifiers (= claimed (= x (= y 0)))))))
		(GetEvent mask self)
		(return self)
	)

	(method (localize param1)
		(if plane
			(LocalToGlobal self plane)
		)
		(GlobalToLocal self (= plane param1))
		(return self)
	)

	(method (globalize)
		(if plane
			(LocalToGlobal self plane)
			(= plane 0)
		)
		(return self)
	)
)

(class User of Obj
	(properties
		state 1
		mousers 0
		input 0
		x 0
		y 0
		orphans 0
		mousePlane 0
		curEvent 0
		hogs 0
		primaDonnas 0
	)

	(method (init)
		(if (not curEvent)
			(= curEvent (Clone Event))
		)
		(if (not hogs)
			(= hogs (HogStack new:))
		)
		(if (not primaDonnas)
			(= primaDonnas (Set new:))
		)
		(if (not orphans)
			(= orphans (Set new:))
		)
		(if (not mousers)
			(= mousers (Set new:))
		)
	)

	(method (dispose)
		(hogs dispose:)
		(primaDonnas release: dispose:)
		(orphans release: dispose:)
		(mousers release: dispose:)
		(curEvent dispose:)
		(= curEvent (= mousers (= orphans (= primaDonnas (= hogs 0)))))
		(super dispose:)
	)

	(method (canInput n)
		(if argc
			(if n
				(|= state $0001)
			else
				(&= state $fffe)
			)
		)
		(return (& state $0001))
	)

	(method (doit)
		(curEvent init:)
		(= gMouseX (curEvent x:))
		(= gMouseY (curEvent y:))
		(self mouseMoved: (or (!= x gMouseX) (!= y gMouseY)))
		(= mousePlane (gPlanes firstTrue: #onMe gMouseX gMouseY))
		(if (or (& state $0001) (self handleHandsOff: curEvent))
			(if (hogs isEmpty:)
				(if gSaveFileSelText
					(gSaveFileSelText handleEvent: curEvent mousePlane)
				)
				(mousers handleEvent: curEvent mousePlane)
				(if (curEvent type:)
					(curEvent globalize:)
					(self handleEvent: curEvent)
				)
			else
				(self processHogs: curEvent)
			)
		)
		(= x gMouseX)
		(= y gMouseY)
	)

	(method (flushEvents)
		(repeat
			(breakif (not ((curEvent init:) type:)))
		)
	)

	(method (handleEvent event)
		(return
			(or
				(self processPrimas: event)
				(gPlanes handleEvent: event)
				(self processOrphans: event)
			)
		)
	)

	(method (handleHandsOff)
		(return 0)
	)

	(method (modalHogs param1)
		(if argc
			(if param1
				(|= state $0004)
			else
				(&= state $fffb)
			)
		)
		(return (& state $0004))
	)

	(method (mouseMoved param1)
		(if argc
			(if param1
				(|= state $0002)
			else
				(&= state $fffd)
			)
		)
		(return (& state $0002))
	)

	(method (processHogs param1 &tmp temp0 temp1 temp2)
		(if (& state $0008)
			(= temp2 1)
		else
			(= temp2 0)
			(|= state $0008)
		)
		(= temp1 (hogs peek:))
		(hogs setMode:)
		(if (& state $0004)
			(= temp0 param1)
			(repeat
				(temp1 handleEvent: temp0)
				(breakif (not (hogs peek:)))
				(if (!= temp1 (hogs peek:))
					(hogs setMode:)
					(cond
						((hogs contains: temp1)
							(if (not (gUser modalHogs:))
								(PrintDebug
									{WARNING: Non modal hog pushed over modal}
								)
							)
						)
						(temp2
							(break)
						)
					)
					(= temp1 (hogs peek:))
				)
				(= x gMouseX)
				(= y gMouseY)
				(temp0 new:)
				(= gMouseX (temp0 x:))
				(= gMouseY (temp0 y:))
				(self mouseMoved: (or (!= x gMouseX) (!= y gMouseY)))
			)
		else
			(temp1 handleEvent: param1)
		)
		(if (not temp2)
			(&= state $fff7)
		)
		(param1 claimed:)
	)

	(method (processPrimas param1)
		(primaDonnas eachElementDo: #handleEvent param1)
		(param1 claimed:)
	)

	(method (processOrphans param1)
		(orphans eachElementDo: #handleEvent param1)
		(param1 claimed:)
	)
)

(class HogStack of Stack
	(properties
		modalHogs 0
	)

	(method (init)
		(super init:)
		(= modalHogs (List new:))
	)

	(method (dispose)
		(if modalHogs
			(modalHogs release: dispose:)
			(= modalHogs 0)
		)
		(super dispose:)
	)

	(method (push param1 param2)
		(if (!= argc 2)
			(PrintDebug {HogStack needs 2 args, got %d} argc)
			(SetDebug self)
		)
		(modalHogs addToFront: param2)
		(self setMode:)
		(super push: param1)
	)

	(method (pop)
		(if (and modalHogs (modalHogs size:))
			(modalHogs delete: (modalHogs at: 0))
			(self setMode:)
			(super pop:)
			(return)
		)
	)

	(method (setMode)
		(if (and modalHogs (modalHogs size:))
			(gUser modalHogs: (modalHogs at: 0))
		)
	)
)

