;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use domino1)
(use Interface)
(use GameControls)
(use System)

(public
	thed1Code 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 45]
	[local52 140]
	[local192 70]
	[local262 85]
	[local347 85]
	[local432 55]
	[local487 75]
	[local562 70]
	[local632 70]
)

(procedure (localproc_0)
	(= local0 global130)
	(= local1 global132)
	(= local2 (BoneYard showAtEnd:))
	(= local3 (BoneYard limit:))
	(= local4 (BoneYard number:))
	(= local5 global148)
	(= global136 (BoneYard number:))
	(= local6 gGameControls)
	(defaultButton helpStr: (Format @local7 199 19)) ; "DEFAULT BUTTON - Set all buttons back to their original settings."
	(helpButton helpStr: (Format @local52 199 20)) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for."
	(OKButton helpStr: (Format @local192 199 21)) ; "OK BUTTON - Pressing this button will put away this Control Panel and return you to whatever you were doing."
	(mustPlaySwitch helpStr: (Format @local262 199 23)) ; "MUST PLAY - If ON, a play must be made if there is one. If OFF, dominoes may be taken from the Boneyard at any time. (Originally ON)"
	(highestDoubletSwitch helpStr: (Format @local347 199 24)) ; "HIGHEST DOUBLET - If ON, the player with the highest doublet plays first. If OFF, players take turns playing the first domino and may play any domino. (Originally ON)"
	(showBoneyardSwitch helpStr: (Format @local432 199 25)) ; "SHOW BONEYARD - If ON, all dominoes in the Boneyard are displayed at the end of each hand. (Originally OFF)"
	(boneyardMinimumSwitch helpStr: (Format @local487 199 26)) ; "BONEYARD MINIMUM - The minimum number of dominoes that must remain in the Boneyard. This may be set to 0 or 2. (Originally 0)"
	(dominoesPerHandSwitch helpStr: (Format @local562 199 27)) ; "DOMINOES PER HAND - The number of dominoes which are taken at the beginning of each hand. This may be set to 5 or 7. (Originally 7)"
	(gameScoreSwitch helpStr: (Format @local632 199 29)) ; "Game Score Limit - Set this switch to the number of points a game consists of. (Default 100)"
	((= gGameControls domino1GameControls)
		window: dominoWindow
		add:
			(defaultButton theObj: defaultButton selector: #doit yourself:)
			helpButton
			(OKButton theObj: OKButton selector: #doit yourself:)
			(mustPlaySwitch
				loop: (if global130 5 else 6)
				theObj: mustPlaySwitch
				selector: #doit
				yourself:
			)
			(highestDoubletSwitch
				loop: (if global132 7 else 8)
				theObj: highestDoubletSwitch
				selector: #doit
				yourself:
			)
			(showBoneyardSwitch
				loop: (if (BoneYard showAtEnd:) 9 else 10)
				theObj: showBoneyardSwitch
				selector: #doit
				yourself:
			)
			(boneyardMinimumSwitch
				loop: (if (== (BoneYard limit:) 0) 11 else 12)
				theObj: boneyardMinimumSwitch
				selector: #doit
				yourself:
			)
			(dominoesPerHandSwitch
				loop: (if (or global135 (== (BoneYard number:) 5)) 13 else 14)
				theObj: dominoesPerHandSwitch
				selector: #doit
				yourself:
			)
			(gameScoreSwitch
				loop: 0
				cel: (+ (/ global148 100) 1)
				theObj: gameScoreSwitch
				selector: #doit
				yourself:
			)
		helpIconItem: helpButton
		curIcon: (if (not (HaveMouse)) OKButton else 0)
	)
	(gGameControls show:)
)

(instance thed1Code of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance domino1GameControls of GameControls
	(properties)

	(method (dispose)
		(thed1Code dispose:)
		(super dispose:)
	)
)

(instance dominoWindow of InvisibleWindow
	(properties
		top 30
		left 53
		bottom 158
		right 267
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 110 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance defaultButton of ControlIcon
	(properties
		view 110
		loop 1
		cel 0
		nsLeft 7
		nsTop 19
		signal 387
		highlightColor -1
	)

	(method (doit)
		(= global130 0)
		(mustPlaySwitch doit:)
		(BoneYard showAtEnd: 1)
		(showBoneyardSwitch doit:)
		(BoneYard limit: 2)
		(boneyardMinimumSwitch doit:)
		(BoneYard number: 5)
		(dominoesPerHandSwitch doit:)
		(gameScoreSwitch cel: 2 show: doit:)
		(= global148 100)
		(= global132 0)
		(highestDoubletSwitch doit:)
	)
)

(instance helpButton of ControlIcon
	(properties
		view 110
		loop 3
		cel 0
		nsLeft 7
		nsTop 71
		cursor 29
		message 6
		signal 387
		highlightColor -1
	)
)

(instance OKButton of ControlIcon
	(properties
		view 110
		loop 4
		cel 0
		nsLeft 7
		nsTop 98
		signal 451
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gDominoes_opt doit: 3)
		(gGameControls hide: dispose:)
		(Animate (gCast elements:) 0)
		(if global135
			(BoneYard number: global136)
		)
		(if (!= global136 (BoneYard number:))
			(if (== (BoneYard mode:) 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= temp0 (gSystemWindow back:))
				(gSystemWindow back: 21)
				(Print
					(Format @global550 199 22 (BoneYard number:)) ; "Select %d Dominoes each"
					#mode
					1
					#at
					-1
					17
					#dispose
				)
			)
			(gSystemWindow back: temp0)
		)
		(if (== ((gCurRoom script:) state:) 3)
			(if (> (BoneYard size:) (BoneYard limit:))
				((BoneYard drawButton:) setLoop: 2)
				(((BoneYard drawButton:) associatedObj:)
					cel: (BoneYard size:)
					show:
				)
			else
				((BoneYard drawButton:) setLoop: 5)
				(((BoneYard drawButton:) associatedObj:) hide:)
			)
		)
		(= gGameControls local6)
		(if
			(and
				(!= local1 global132)
				global132
				(== ((gCurRoom script:) state:) 2)
			)
			(proc100_1)
		)
	)
)

(instance mustPlaySwitch of ControlIcon
	(properties
		view 110
		cel 0
		nsLeft 65
		nsTop 19
		signal 387
		highlightColor -1
	)

	(method (doit)
		(= loop (if (= global130 (- 1 global130)) 5 else 6))
		(self show:)
	)
)

(instance highestDoubletSwitch of ControlIcon
	(properties
		view 110
		cel 0
		nsLeft 65
		nsTop 36
		signal 387
		maskView 110
		maskLoop 7
		maskCel 2
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(= loop (if (= global132 (- 1 global132)) 7 else 8))
		(self show:)
	)
)

(instance showBoneyardSwitch of ControlIcon
	(properties
		view 110
		cel 0
		nsLeft 65
		nsTop 55
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (BoneYard showAtEnd:)
			(BoneYard showAtEnd: 0)
		else
			(BoneYard showAtEnd: 1)
		)
		(= loop (if (BoneYard showAtEnd:) 9 else 10))
		(self show:)
		(if (and global129 (<= 4 ((gCurRoom script:) state:) 6))
			(if (BoneYard showAtEnd:)
				(gShowBoneYard init: global137)
			else
				(gShowBoneYard hide:)
			)
		)
	)
)

(instance boneyardMinimumSwitch of ControlIcon
	(properties
		view 110
		cel 0
		nsLeft 65
		nsTop 71
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (== (BoneYard limit:) 0)
			(BoneYard limit: 2)
		else
			(BoneYard limit: 0)
		)
		(= loop (if (== (BoneYard limit:) 0) 11 else 12))
		(self show:)
	)
)

(instance dominoesPerHandSwitch of ControlIcon
	(properties
		view 110
		cel 0
		nsLeft 65
		nsTop 88
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (== (BoneYard number:) 5)
			(BoneYard number: 7)
		else
			(BoneYard number: 5)
		)
		(= loop (if (== (BoneYard number:) 5) 13 else 14))
		(self show:)
		(= global135 0)
		(if
			(and
				(== ((gCurRoom script:) state:) 1)
				(<= (BoneYard size:) (- 28 (* (BoneYard number:) 2)))
			)
			(Print 199 28) ; "The change to 5 Dominoes per hand will take effect at the beginning of the next hand."
			(= global135 5)
		)
	)
)

(instance gameScoreSwitch of ControlIcon
	(properties
		view 110
		cel 3
		nsLeft 65
		nsTop 105
		signal 387
		highlightColor -1
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 cel)
		(if (> (= temp2 (+ cel 1)) 6)
			(= temp2 2)
		)
		(if (and argc param1 (& signal $0001))
			(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
				(temp0 localize:)
				(cond
					((self onMe: temp0)
						(if (!= temp1 1)
							(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
							(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
						)
					)
					((== temp1 1)
						(DrawCel view loop (= temp1 temp3) nsLeft nsTop -1)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
				)
				(temp0 dispose:)
			)
			(temp0 dispose:)
			(if (== temp1 1)
				(DrawCel view loop (= cel temp2) nsLeft nsTop -1)
				(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
				(= global148 (* (- cel 1) 100))
			)
			(return temp1)
		else
			(return 1)
		)
	)
)

