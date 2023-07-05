;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use RotProp)

(public
	broochCloseUp 0
)

(local
	local0 = -1
)

(instance broochCloseUp of RotProp
	(properties
		noun 11
		modNum 1
		view 9720
		baseView 9720
	)

	(method (init param1 param2 param3 param4)
		(if (not (IsFlag 81))
			(self view: 9720 baseView: 9720)
		else
			(self view: 9870 baseView: 9870)
		)
		(= local0 -1)
		(super init: param1 param2 param3 param4)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= local0 cel)
			(= local0 cel)
			(if (or (== cel 0) (> cel 11))
				(self setHotspot: 0)
			else
				(self setHotspot: 4 3) ; Do, Move
			)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(if (== theVerb 4) ; Do
			(if (not (IsFlag 81))
				(SetFlag 81)
				(= temp2 (gInventory at: 10)) ; invBrooch
				(= temp0 (temp2 view:))
				(= temp1 9871)
				(temp2
					view: 9871
					hiliteView: 9871
					loliteView: (+ 9871 1)
					loop: 0
					cel: 0
					verb: 37
				)
				(self view: 9870 baseView: 9870)
				(gInvCursor
					view: (temp2 loliteView:)
					loop: (temp2 loop:)
					cel: (temp2 cel:)
				)
			else
				(ClearFlag 81)
				(= temp2 (gInventory at: 10)) ; invBrooch
				(= temp0 (temp2 view:))
				(= temp1 9721)
				(temp2
					view: 9721
					hiliteView: 9721
					loliteView: (+ 9721 1)
					loop: 0
					cel: 0
					verb: 16
				)
				(self view: 9720 baseView: 9720)
				(gInvCursor
					view: (temp2 loliteView:)
					loop: (temp2 loop:)
					cel: (temp2 cel:)
				)
			)
			(Lock rsVIEW temp0 0)
			(Lock rsVIEW (+ temp0 1) 0)
			(Lock rsVIEW temp1 1)
			(Lock rsVIEW (+ temp1 1) 1)
		else
			(super doVerb: theVerb)
		)
	)
)

