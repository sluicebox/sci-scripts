;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Print)
(use BorderWindow)
(use IconBar)
(use Inventory)
(use System)

(public
	invSetupCode 0
	invBitCode 1
)

(instance invSetupCode of Code
	(properties)

	(method (init)
		((= gInventory Inv)
			init:
			window: invWindow
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: invOk
			add: buckazoid passport E_corder amulet
			eachElementDo: #init
		)
	)

	(method (doit param1)
		(gInventory param1: invLook invHand invSelect invHelp invOk)
	)
)

(instance invBitCode of Code
	(properties)

	(method (init &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (- (gInventory size:) 5)) ((++ temp0))
			(if
				(&
					[global155 (/ (= temp1 ((gInventory at: temp0) flag:)) 16)]
					(>> $8000 (mod temp1 16))
				)
				(gEgo get: temp0)
				(&= [global155 (/ temp1 16)] (~ (>> $8000 (mod temp1 16))))
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (- (gInventory size:) 5)) ((++ temp0))
			(if (== ((gInventory at: temp0) owner:) gEgo)
				(= [global155 (/ temp1 16)]
					(|
						[global155 (/ (= temp1 ((gInventory at: temp0) flag:)) 16)]
						(>> $8000 (mod temp1 16))
					)
				)
			)
		)
	)
)

(class EcoI of IconI
	(properties
		view 991
		nsTop 1
		highlightColor -1
		lowlightColor -1
		modNum 99
	)

	(method (ownedBy)
		(return 0)
	)
)

(class EcoInvI of InvI
	(properties
		view 950
		signal 2
		highlightColor -1
		lowlightColor -1
		modNum 99
		flag -1
	)

	(method (select)
		(if (super select: &rest)
			((= cursor gTheCursor) loop: loop cel: cel init:)
			(gInventory curIcon: self)
			(if (gTheIconBar curInvIcon:)
				(gTheIconBar curInvIcon: self)
			)
			(return 1)
		)
	)

	(method (doVerb theVerb &tmp [temp0 50] [temp50 20] [temp70 20])
		(Print font: gUserFont mode: 1)
		(switch theVerb
			(6 ; ???
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(Print addText: noun 1 0 0 0 0 modNum init:)
			)
			(4 ; Do
				(self select: &rest)
			)
			(else
				(Message msgGET 99 1 0 1 1 @temp0) ; "Adam can't use the %s on the %s."
				(Message msgGET 99 1 theVerb 0 1 @temp50)
				(Message msgGET 99 1 (self message:) 0 1 @temp70)
				(Print addTextF: @temp0 @temp50 @temp70 init:)
			)
		)
	)
)

(instance invWindow of InsetWindow
	(properties
		priority -1
		topBordHgt 32
		botBordHgt 5
	)

	(method (open &tmp temp0 temp1 temp2)
		(= back 66)
		(= topBordColor 68)
		(= lftBordColor 67)
		(= botBordColor 64)
		(= rgtBordColor 65)
		(= insideColor 11)
		(= topBordColor2 65)
		(= lftBordColor2 66)
		(= rgtBordColor2 67)
		(= botBordColor2 68)
		(= temp0 0)
		(for
			((= temp1 (gInventory first:)))
			temp1
			((= temp1 (gInventory next: temp1)))
			
			(if (not ((= temp2 (NodeValue temp1)) isKindOf: InvI))
				(+= temp0 (CelWide (temp2 view:) (temp2 loop:) (temp2 cel:)))
			)
		)
		(super open:)
		(invLook nsLeft: (/ (- (- right left) temp0) 2))
	)
)

(instance invLook of EcoI
	(properties
		loop 0
		cel 0
		cursor 1
		message 1
		signal 129
		noun 5
		helpVerb 6
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if (== ((gGame script:) register:) self)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

(instance invHand of EcoI
	(properties
		loop 1
		cel 0
		cursor 2
		message 4
		noun 2
		helpVerb 6
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if (== ((gGame script:) register:) self)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

(instance invSelect of EcoI
	(properties
		loop 2
		cel 0
		cursor 999
		message 70
		noun 6
		helpVerb 6
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if (== ((gGame script:) register:) self)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

(instance invHelp of EcoI
	(properties
		loop 3
		cel 0
		cursor 9
		type 8192
		message 6
		noun 4
		helpVerb 6
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if (== ((gGame script:) register:) self)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

(instance invOk of EcoI
	(properties
		loop 4
		cel 0
		cursor 999
		message 54
		noun 3
		helpVerb 6
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if (== ((gGame script:) register:) self)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

(instance buckazoid of EcoInvI
	(properties
		cel 2
		message 7
		noun 7
		flag 0
	)

	(method (doVerb theVerb)
		(if (IsFlag 3)
			((gGame script:) report:)
		else
			(super doVerb: theVerb)
		)
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if (== ((gGame script:) register:) self)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

(instance passport of EcoInvI
	(properties
		message 8
		noun 8
		flag 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 3)
					(if (== ((gGame script:) state:) 7)
						(gInventory hide:)
						(= cel 1)
						(gInventory show:)
						((gGame script:) cue:)
					else
						((gGame script:) report:)
					)
				else
					(gInventory hide:)
					(= cel (if cel 0 else 1))
					(gInventory show:)
				)
			)
			(1 ; Look
				(cond
					((IsFlag 3)
						((gGame script:) report:)
					)
					((== cel 1)
						(gMessager say: noun theVerb 6 0 0 99) ; "Adam's immunization card and passport are in order."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(if (IsFlag 3)
					((gGame script:) report:)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if
				(and
					(== ((gGame script:) register:) self)
					(== ((gGame script:) state:) 11)
				)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

(instance E_corder of EcoInvI
	(properties
		name {E-corder}
		loop 8
		cel 8
		message 55
		noun 54
		flag 2
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (not (gCurRoom inset:))) ; Do
				(gInventory hide:)
				(gCurRoom setInset: (ScriptID 50)) ; inEcorder
			)
			((IsFlag 3)
				((gGame script:) report:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if (== ((gGame script:) register:) self)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

(instance amulet of EcoInvI
	(properties
		cel 5
		message 13
		noun 12
		flag 3
	)

	(method (doVerb theVerb)
		(if (IsFlag 3)
			((gGame script:) report:)
		else
			(super doVerb: theVerb)
		)
	)

	(method (select &tmp temp0)
		(= temp0 0)
		(if (IsFlag 3)
			(if (== ((gGame script:) register:) self)
				(= temp0 (super select: &rest))
				((gGame script:) cue:)
			else
				((gGame script:) report:)
			)
			(return temp0)
		else
			(return (super select: &rest))
		)
	)
)

