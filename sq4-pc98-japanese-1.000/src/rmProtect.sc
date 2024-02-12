;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 815)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use Sound)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rmProtect 0
)

(local
	[local0 4] = [0 10 20 30]
	[local4 5] = [0 10 20 30 40]
	local9
	local10
	[local11 10]
	[local21 5]
	[local26 5]
	local31
	local32
)

(procedure (localproc_0 param1 param2 param3)
	(param1
		nsLeft: (param1 x:)
		nsTop: (param1 y:)
		nsRight: (+ (param1 x:) param2)
		nsBottom: (+ (param1 y:) param3)
	)
)

(procedure (localproc_1)
	(switch (StrLen @local21)
		(0
			(l1 cel: 1)
		)
		(1
			(l2 cel: 1)
		)
		(2
			(l3 cel: 1)
		)
		(3
			(l4 cel: 1)
		)
	)
)

(procedure (localproc_2)
	(l1 cel: 0)
	(l2 cel: 0)
	(l3 cel: 0)
	(l4 cel: 0)
)

(instance rmProtect of Rm
	(properties
		picture 803
		style 10
	)

	(method (init)
		(Load rsVIEW 815)
		(Load rsFONT 10)
		(Load rsSOUND 812)
		(switch gPrevRoomNum
			(530
				(= local31 531)
			)
		)
		(User mapKeyToDir: 0)
		(gTheIconBar disable:)
		(for
			((= local10 (= local9 (Random (Random 0 2) (Random 3 4)))))
			(== local10 local9)
			((= local10 (Random (Random 0 2) (Random 3 4))))
		)
		(StrCpy @local26 {})
		(StrCpy @local21 {})
		(switch local9
			(0
				(StrCat @local11 {\1a})
				(StrCpy @local26 {XW})
			)
			(1
				(StrCat @local11 {\1b})
				(StrCpy @local26 {AO})
			)
			(2
				(StrCat @local11 {\1c})
				(StrCpy @local26 {ER})
			)
			(3
				(StrCat @local11 {\1d})
				(StrCpy @local26 {SR})
			)
			(4
				(StrCat @local11 {\1e})
				(StrCpy @local26 {AW})
			)
		)
		(switch local10
			(0
				(StrCat @local11 { \1a})
				(StrCat @local26 {XW})
			)
			(1
				(StrCat @local11 { \1b})
				(StrCat @local26 {AO})
			)
			(2
				(StrCat @local11 { \1c})
				(StrCat @local26 {ER})
			)
			(3
				(StrCat @local11 { \1d})
				(StrCat @local26 {SR})
			)
			(4
				(StrCat @local11 { \1e})
				(StrCat @local26 {AW})
			)
		)
		(super init:)
		(gSounds eachElementDo: #pause 1 doit:)
		(backGround number: 890 loop: -1 playBed:)
		(keyPad init:)
		(self setScript: startScript)
	)

	(method (dispose)
		(User mapKeyToDir: 1)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(class padButton of Feature
	(properties
		theString 0
		strToCat 0
		keyEquiv 0
		who 0
		scriptToCue 0
	)

	(method (init param1)
		(super init: &rest)
		(= theString param1)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(if who
			(who x: (self x:) y: (self y:) init: hide:)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(if who
			(who dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) KEY_RETURN)
						(== (& (event message:) $ffdf) keyEquiv)
					)
					(if scriptToCue
						(gCurRoom setScript: scriptToCue)
					)
					(event claimed: 1)
					(self doit:)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(if scriptToCue
						(gCurRoom setScript: scriptToCue)
					)
					(event claimed: 1)
					(self doit:)
				)
			)
		)
	)

	(method (doit)
		(who setScript: (Clone keyFlashScript) scriptToCue)
		(if (and strToCat (< (StrLen theString) 4))
			(localproc_1)
			(StrCat theString strToCat)
		)
	)
)

(instance keyFlashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client show:)
				(keySound number: 812 loop: 0 play:)
				(= cycles 3)
			)
			(1
				(client hide: setScript: 0)
			)
		)
	)
)

(instance keySound of Sound
	(properties)
)

(instance backGround of Sound
	(properties)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(cond
					((not (StrLen @local21))
						(Print 815 0) ; "Please enter the correct X/Y coordinates, then press 'DONE'."
					)
					((not (StrCmp @local26 @local21))
						(gSounds eachElementDo: #pause 0 doit:)
						(backGround stop:)
						(SetFlag 78)
						(gCurRoom newRoom: local31)
					)
					((<= (++ local32) 2)
						(StrCpy @local21 {})
						(localproc_2)
						(Print 815 1) ; "Sorry, you entered in the wrong X/Y coordinates. We'll give you another chance."
					)
					(else
						(Print 815 2) ; "Sorry, wrong X/Y coordinates."
						(gCurRoom newRoom: gPrevRoomNum)
					)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance startScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Display 815 3 dsFONT 3 dsCOORD 26 29 dsWIDTH 166 dsALIGN alCENTER dsCOLOR global135) ; "Okay, here's the dumb copy protection. In your documentation find the X/Y coordinates (letters) for each of the two displayed symbols. Enter the four letters by clicking either the appropriate buttons or typing the correct keys, and finish by pressing either 'DONE' or the 'ENTER' key."
				(= cycles 1)
			)
			(1
				(Display @local11 dsCOORD 231 69 dsFONT 10 dsCOLOR global135)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance keyPad of View
	(properties
		x 228
		y 97
		view 815
	)

	(method (init)
		(super init: &rest)
		(self signal: 257)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(l1 init:)
		(l2 init:)
		(l3 init:)
		(l4 init:)
		(aBut who: aDown init: @local21)
		(bBut who: bDown init: @local21)
		(cBut who: cDown init: @local21)
		(eBut who: eDown init: @local21)
		(gBut who: gDown init: @local21)
		(iBut who: iDown init: @local21)
		(lBut who: lDown init: @local21)
		(oBut who: oDown init: @local21)
		(rBut who: rDown init: @local21)
		(sBut who: sDown init: @local21)
		(tBut who: tDown init: @local21)
		(wBut who: wDown init: @local21)
		(xBut who: xDown init: @local21)
		(enterBut who: enterDown scriptToCue: enterScript init: @local21)
		(hand x: ((User curEvent:) x:) y: ((User curEvent:) y:) init:)
	)

	(method (dispose)
		(User mapKeyToDir: 1)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance l1 of View
	(properties
		view 815
		loop 2
		priority 6
		signal 16
	)

	(method (init)
		(self x: (+ (keyPad x:) 7) y: (- (keyPad y:) 8))
		(super init: &rest)
	)
)

(instance l2 of View
	(properties
		view 815
		loop 2
		priority 6
		signal 16
	)

	(method (init)
		(self x: (+ (keyPad x:) 14) y: (- (keyPad y:) 8))
		(super init: &rest)
	)
)

(instance l3 of View
	(properties
		view 815
		loop 2
		priority 6
		signal 16
	)

	(method (init)
		(self x: (+ (keyPad x:) 21) y: (- (keyPad y:) 8))
		(super init: &rest)
	)
)

(instance l4 of View
	(properties
		view 815
		loop 2
		priority 6
		signal 16
	)

	(method (init)
		(self x: (+ (keyPad x:) 28) y: (- (keyPad y:) 8))
		(super init: &rest)
	)
)

(instance hand of View
	(properties
		view 502
		cel 2
		priority 15
		signal 16
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (User curEvent:))
		(if (not (& (temp0 type:) $0007)) ; evMOUSEKEYBOARD | evMOUSERELEASE
			(GlobalToLocal temp0)
			(= temp1 (temp0 x:))
			(= temp2 (+ (temp0 y:) 10))
			(if (InRect 0 0 320 190 temp1 temp2)
				(gGame setCursor: 69 1)
				(self show: x: temp1 y: temp2)
			else
				(gGame setCursor: gNormalCursor 1)
				(self hide:)
			)
		)
		(super doit:)
	)
)

(instance aBut of padButton
	(properties
		strToCat {A}
		keyEquiv 65
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 0]) y: (+ (keyPad y:) [local4 0]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance bBut of padButton
	(properties
		strToCat {B}
		keyEquiv 66
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 1]) y: (+ (keyPad y:) [local4 0]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance cBut of padButton
	(properties
		strToCat {C}
		keyEquiv 67
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 2]) y: (+ (keyPad y:) [local4 0]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance eBut of padButton
	(properties
		strToCat {E}
		keyEquiv 69
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 3]) y: (+ (keyPad y:) [local4 0]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance gBut of padButton
	(properties
		strToCat {G}
		keyEquiv 71
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 0]) y: (+ (keyPad y:) [local4 1]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance iBut of padButton
	(properties
		strToCat {I}
		keyEquiv 73
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 1]) y: (+ (keyPad y:) [local4 1]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance lBut of padButton
	(properties
		strToCat {L}
		keyEquiv 76
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 2]) y: (+ (keyPad y:) [local4 1]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance oBut of padButton
	(properties
		strToCat {O}
		keyEquiv 79
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 3]) y: (+ (keyPad y:) [local4 1]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance rBut of padButton
	(properties
		strToCat {R}
		keyEquiv 82
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 0]) y: (+ (keyPad y:) [local4 2]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance sBut of padButton
	(properties
		strToCat {S}
		keyEquiv 83
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 1]) y: (+ (keyPad y:) [local4 2]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance tBut of padButton
	(properties
		strToCat {T}
		keyEquiv 84
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 2]) y: (+ (keyPad y:) [local4 2]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance wBut of padButton
	(properties
		strToCat {W}
		keyEquiv 87
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 3]) y: (+ (keyPad y:) [local4 2]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance xBut of padButton
	(properties
		strToCat {X}
		keyEquiv 88
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 0]) y: (+ (keyPad y:) [local4 3]))
		(localproc_0 self 8 8)
		(super init: &rest)
	)
)

(instance enterBut of padButton
	(properties
		keyEquiv 13
	)

	(method (init)
		(self x: (+ (keyPad x:) [local0 1]) y: (+ (keyPad y:) [local4 3]))
		(localproc_0 self 28 8)
		(super init: &rest)
	)
)

(instance aDown of Prop
	(properties
		view 815
		loop 1
		priority 15
	)
)

(instance bDown of Prop
	(properties
		view 815
		loop 1
		cel 1
		priority 15
	)
)

(instance cDown of Prop
	(properties
		view 815
		loop 1
		cel 2
		priority 15
	)
)

(instance eDown of Prop
	(properties
		view 815
		loop 1
		cel 3
		priority 15
	)
)

(instance gDown of Prop
	(properties
		view 815
		loop 1
		cel 4
		priority 15
	)
)

(instance iDown of Prop
	(properties
		view 815
		loop 1
		cel 5
		priority 15
	)
)

(instance lDown of Prop
	(properties
		view 815
		loop 1
		cel 6
		priority 15
	)
)

(instance oDown of Prop
	(properties
		view 815
		loop 1
		cel 7
		priority 15
	)
)

(instance rDown of Prop
	(properties
		view 815
		loop 1
		cel 8
		priority 15
	)
)

(instance sDown of Prop
	(properties
		view 815
		loop 1
		cel 9
		priority 15
	)
)

(instance tDown of Prop
	(properties
		view 815
		loop 1
		cel 10
		priority 15
	)
)

(instance wDown of Prop
	(properties
		view 815
		loop 1
		cel 11
		priority 15
	)
)

(instance xDown of Prop
	(properties
		view 815
		loop 1
		cel 12
		priority 15
	)
)

(instance enterDown of Prop
	(properties
		view 815
		loop 1
		cel 13
		priority 15
	)
)

