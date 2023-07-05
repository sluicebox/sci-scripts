;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8000)
(include sci.sh)
(use Main)
(use oInterface)
(use oHandsOnWhenCued)
(use TPScript)
(use Plane)

(public
	roPrologue1 0
)

(instance soPlayPrologue of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PlayVMD 0 {10000.vmd}) ; Open
				(if (< gnVideoSpeed 425)
					(PlayVMD 1 162 161) ; Put
				else
					(PlayVMD 1 4 82 21 50 0 10000) ; Put
				)
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= ticks 1)
			)
			(1
				(PlayVMD 0 {10001.vmd}) ; Open
				(if (< gnVideoSpeed 425)
					(PlayVMD 1 162 161) ; Put
				else
					(PlayVMD 1 4 82 5) ; Put
				)
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= ticks 1)
			)
			(2
				(Palette 1 999) ; PalLoad
				(Palette 1 10000) ; PalLoad
				(gGame setCursor: (ScriptID 64006 0) 0) ; oSysCursor
				(gGame setCursor: (ScriptID 64006 0) 1) ; oSysCursor
				(if (not gbInterfaceInitted)
					((ScriptID 64002 0) init:) ; oInterface
					(InitInterface2)
				)
				(gCurRoom newRoom: 10000) ; roChapter1
			)
		)
	)
)

(instance oBlackPlane of Plane
	(properties
		priority 700
	)

	(method (init)
		(super init: 0 0 gLastScreenX gLastScreenY)
	)
)

(instance roPrologue1 of TPRoom
	(properties)

	(method (init)
		(= plane (oBlackPlane init: yourself:))
		(super init: &rest)
		(goMusic1 stop:)
		(= gnChapter 0)
		(gCurRoom setScript: soPlayPrologue)
	)
)

