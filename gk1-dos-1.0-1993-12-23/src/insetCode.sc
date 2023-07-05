;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use GKIconbar)
(use n013)
(use Inset)
(use IconBar)
(use Actor)
(use System)

(public
	insetCode 0
	invInset 1
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 14]
)

(instance insetCode of Code
	(properties)

	(method (doit param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0)
		(gInventory stifleCue: 1)
		(= local2 (GKIconbar curIcon:))
		(for ((= temp0 0)) (< temp0 14) ((++ temp0))
			(= [local5 temp0] 0)
		)
		(gTheIconBar eachElementDo: #perform checkIcon)
		(gTheIconBar disable: 0 1 2 4 6 7 8 9 10 12)
		(= local0 0)
		(= local1 0)
		(if (and (== argc 8) param8)
			(= local0 param8)
			(magFrame noun: param6)
		)
		(if (and (>= argc 7) param7)
			(= local3 param7)
		else
			(= local3 0)
		)
		(invInset
			view: param1
			loop: param2
			cel: param3
			x: param4
			y: param5
			noun: param6
			priority: 15
			disposeNotOnMe: 1
		)
		(if (gCurRoom inset:)
			(= local1 ((gCurRoom inset:) caller:))
			((gCurRoom inset:) caller: 0 dispose:)
		)
		(invInset init: 0 gCurRoom 1)
	)
)

(instance magFrame of View
	(properties
		modNum 15
		view 1
	)

	(method (init)
		(self view: local0)
		(if (> local0 1)
			(self view: local0 x: 15 y: 13)
		else
			(self view: 1 x: 0 y: 0)
		)
		(self signal: (| signal $1000))
		(super init:)
	)

	(method (doVerb theVerb)
		(if gMsgType
			(cond
				((Message msgGET modNum noun theVerb local3 1)
					(gMessager say: noun theVerb local3 0 0 modNum)
				)
				((== theVerb 4) ; magGlass
					(gMessager say: 0 4 21 0 0 15) ; "Gabriel is already using the magnifying glass."
				)
				(else
					(gMessager say: 0 theVerb 0 0 0 0)
				)
			)
		)
		(return 1)
	)
)

(instance fortuneScale of View
	(properties
		noun 76
		modNum 15
		x 46
		y 55
		view 97
		loop 1
	)

	(method (doVerb theVerb &tmp temp0)
		(if (IsFlag 309)
			(= temp0 15)
		else
			(SetFlag 309)
			(= temp0 14)
		)
		(if gMsgType
			(cond
				((Message msgGET modNum noun theVerb temp0 1)
					(gMessager say: noun theVerb temp0 0 0 modNum)
				)
				((== theVerb 4) ; magGlass
					(gMessager say: 76 4 0 0 0 15) ; "Gabriel is already using the magnifying glass."
				)
				(else
					(gMessager say: 0 theVerb 0 0 0 0)
				)
			)
		)
		(return 1)
	)
)

(instance delayForHide of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gTheIconBar curIcon: (GKIconbar at: 3))
				(gGame setCursor: ((GKIconbar curIcon:) cursorView:) 1)
				(self dispose:)
			)
		)
	)
)

(instance invInset of Inset
	(properties
		modNum 15
	)

	(method (init &tmp temp0)
		(if local0
			(= picture -2)
		)
		(= local4 0)
		(self setScript: delayForHide)
		(if (> local0 1)
			(= priority 14)
		else
			(= priority 15)
		)
		(super init: &rest)
		(if local0
			(magFrame init: setPri: 15)
			(plane setSize:)
			(UpdateScreenItem magFrame)
			(UpdatePlane plane)
		)
		(if (and (== (self view:) 97) (not (IsFlag 310)))
			(= local4 1)
			(fortuneScale init: setPri: 16)
			(UpdateScreenItem fortuneScale)
		)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (dispose &tmp [temp0 2])
		(if (and (== view 50) (== ((plane bitmap:) cel:) 0))
			(self reDrawInset:)
			(return)
		)
		(if (not (gInventory theCaller:))
			(gInventory theCaller: local1)
		)
		(if local0
			(magFrame dispose:)
		)
		(if local4
			(fortuneScale dispose:)
		)
		(restoreIB doit:)
		(super dispose:)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(GKIconbar curIcon: local2)
		(FrameOut)
		(gInventory showSelf: (gInventory curPage:))
	)

	(method (doVerb theVerb)
		(if gMsgType
			(cond
				((Message msgGET modNum noun theVerb local3 1)
					(gMessager say: noun theVerb local3 0 0 modNum)
				)
				((== theVerb 4) ; magGlass
					(gMessager say: 0 4 21 0 0 15) ; "Gabriel is already using the magnifying glass."
				)
				(else
					(gMessager say: 0 theVerb 0 0 0 0)
				)
			)
		)
		(return 1)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (and (param1 isKindOf: IconI) (not (& (param1 signal:) $0004)))
			(= [local5 (gTheIconBar indexOf: param1)] 1)
		)
	)
)

(instance restoreIB of Code
	(properties)

	(method (doit &tmp temp0)
		(for ((= temp0 0)) (< temp0 14) ((++ temp0))
			(if (== [local5 temp0] 1)
				((gTheIconBar at: temp0)
					signal: (& ((gTheIconBar at: temp0) signal:) $fffb)
				)
			)
		)
	)
)

