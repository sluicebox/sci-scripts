;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 907)
(include sci.sh)
(use Main)
(use KQ6Print)
(use Kq6Window)
(use n913)
(use IconBar)
(use Window)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	KqInv 0
	pageCode 1
)

(local
	local0
	local1
)

(class Kq6InvItem of InvI
	(properties
		view 970
		modNum 907
		realOwner 0
		cursorView 0
		cursorLoop 0
		cursorCel 0
		hideInv 0
	)

	(method (doVerb theVerb &tmp temp0 [temp1 100])
		(if (OneOf theVerb 28 13 12) ; spellBook, mirror, map
			(gMessager say: 0 theVerb 0 0 0 modNum)
		else
			(if hideInv
				(gInventory hide: 1)
			)
			(if (not modNum)
				(= modNum gCurRoomNum)
			)
			(cond
				(
					(and
						gMsgType
						(Message msgGET modNum noun theVerb 0 1)
						(!= (gMessager findTalker: (Message msgNEXT 0)) -1)
					)
					(if hideInv
						(gMessager say: noun theVerb 0 0 self modNum)
					else
						(gMessager say: noun theVerb 0 0 0 modNum)
					)
				)
				(
					(and
						(gInventory curIcon:)
						(!= (gInventory curIcon:) self)
						((gInventory curIcon:) isKindOf: InvI)
						(= temp0 (Message msgGET modNum noun theVerb 0 1))
						(!= (gMessager findTalker: temp0) -1)
					)
					((gInventory curIcon:) doVerb: message)
				)
				(else
					(switch theVerb
						(5 ; Do
							(gMessager say: 64 5 0 0 0 modNum) ; "It feels just as it appears."
						)
						(2 ; Talk
							(gMessager say: 64 2 0 0 0 modNum) ; "That object has nothing to say."
						)
						(else
							(gMessager say: noun 0 0 0 0 modNum)
						)
					)
				)
			)
		)
	)

	(method (checkPage &tmp temp0 temp1)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 52) ((++ temp0))
			(if (== ((gInventory at: temp0) owner:) local1)
				(= temp1 1)
				(= temp0 53)
			)
		)
		(gInventory hide:)
		(if temp1
			(if (> temp0 52)
				(gInventory show: local1 selectIcon: invSelect)
			else
				(invPrevious select:)
			)
		)
	)

	(method (setCursor param1 param2 param3)
		(= cursorView param1)
		(= cursorLoop param2)
		(= cursorCel param3)
		(= cursor genericCursor)
	)

	(method (select)
		(genericCursor view: cursorView loop: cursorLoop cel: cursorCel)
		(gGame setCursor: genericCursor)
		(super select: &rest)
	)

	(method (show)
		(= view 970)
		(super show: &rest)
	)

	(method (cue param1)
		(if (and argc param1)
			(pageCode init: local1)
		else
			(if (not gSet)
				(= gSet (Set new:))
			)
			(gSet
				add: ((Cue new:) cuee: self cuer: self register: 1 yourself:)
			)
		)
	)
)

(instance pageCode of Code
	(properties)

	(method (init param1 &tmp temp0 temp1)
		(= local1 param1)
		(gInventory selectIcon: invSelect window: invWin)
		(invSelect loop: 4 message: -1)
		(= local0 0)
		(for ((= temp0 0)) (< temp0 52) ((++ temp0))
			(if (== ((= temp1 (gInventory at: temp0)) owner:) local1)
				(temp1 realOwner: (temp1 owner:) owner: 0)
				(if (< (++ local0) 13)
					(temp1 owner: local1)
				)
			)
		)
		(if local0
			(gInventory addAfter: invTalk invMore)
		)
		(gInventory delete: invPrevious showSelf: local1)
	)
)

(instance KqInv of Inv
	(properties
		normalHeading {Alexander is carrying}
		empty {nothing.}
	)

	(method (hide param1 &tmp temp0 temp1 temp2 temp3)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
		(if window
			(window dispose:)
		)
		(if (and (IsObject curIcon) (curIcon isKindOf: InvI))
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar enable: (gTheIconBar useIconItem:))
			)
			(gTheIconBar
				curIcon:
					((gTheIconBar useIconItem:)
						cursor: (curIcon cursor:)
						yourself:
					)
				curInvIcon: curIcon
			)
			(Platform 0 4 4 5 (gInventory indexOf: (gInventory curIcon:)))
			(if
				(and
					(gGame isHandsOn:)
					(= temp2 ((gTheIconBar curIcon:) cursor:))
				)
				(gGame setCursor: temp2)
			)
		else
			(if (IsObject (= temp3 (gTheIconBar curInvIcon:)))
				(genericCursor
					view: (temp3 cursorView:)
					loop: (temp3 cursorLoop:)
					cel: (temp3 cursorCel:)
				)
			)
			(if
				(and
					(gGame isHandsOn:)
					(= temp2 ((gTheIconBar curIcon:) cursor:))
				)
				(gGame setCursor: temp2)
			)
		)
		(if (or (not argc) (not param1))
			(for ((= temp0 0)) (< temp0 52) ((++ temp0))
				(if ((= temp1 (self at: temp0)) realOwner:)
					(temp1 owner: (temp1 realOwner:))
					(temp1 realOwner: 0)
				)
			)
			(self delete: invMore invPrevious)
		)
		(gTheIconBar enable:)
	)

	(method (init)
		(= gInventory self)
		(self
			add:
				(map setCursor: 990 1 7 yourself:)
				(boringBook setCursor: 990 0 0 yourself:)
				(brick setCursor: 990 0 1 yourself:)
				(brush setCursor: 990 0 2 yourself:)
				(hair setCursor: 990 0 15 yourself:)
				(clothes setCursor: 990 0 4 yourself:)
				(coal setCursor: 990 0 5 yourself:)
				(deadMansCoin setCursor: 990 0 6 yourself:)
				(dagger setCursor: 990 0 7 yourself:)
				(coin setCursor: 990 0 8 yourself:)
				(egg setCursor: 990 0 10 yourself:)
				(skull setCursor: 990 3 4 yourself:)
				(feather setCursor: 990 0 11 yourself:)
				(flower setCursor: 990 0 12 yourself:)
				(flute setCursor: 990 0 13 yourself:)
				(gauntlet setCursor: 990 0 14 yourself:)
				(cassimaHair setCursor: 990 0 3 yourself:)
				(handkerchief setCursor: 990 1 0 yourself:)
				(holeInTheWall setCursor: 990 1 1 yourself:)
				(huntersLamp setCursor: 990 1 2 yourself:)
				(letter setCursor: 990 1 3 yourself:)
				(lettuce setCursor: 990 1 4 yourself:)
				(milk setCursor: 990 1 8 yourself:)
				(mint setCursor: 990 1 9 yourself:)
				(mirror setCursor: 990 1 10 yourself:)
				(newLamp setCursor: 990 1 11 yourself:)
				(nail setCursor: 990 2 0 yourself:)
				(nightingale setCursor: 990 2 1 yourself:)
				(ticket setCursor: 990 3 7 yourself:)
				(participle setCursor: 990 2 3 yourself:)
				(pearl setCursor: 990 2 4 yourself:)
				(peppermint setCursor: 990 2 5 yourself:)
				(note setCursor: 990 2 6 yourself:)
				(potion setCursor: 990 2 7 yourself:)
				(rabbitFoot setCursor: 990 2 8 yourself:)
				(ribbon setCursor: 990 2 10 yourself:)
				(riddleBook setCursor: 990 2 11 yourself:)
				(ring setCursor: 990 2 12 yourself:)
				(rose setCursor: 990 2 13 yourself:)
				(royalRing setCursor: 990 2 14 yourself:)
				(sacredWater setCursor: 990 2 15 yourself:)
				(scarf setCursor: 990 3 0 yourself:)
				(scythe setCursor: 990 3 1 yourself:)
				(shield setCursor: 990 3 2 yourself:)
				(skeletonKey setCursor: 990 3 3 yourself:)
				(spellBook setCursor: 990 3 5 yourself:)
				(teaCup setCursor: 990 3 6 yourself:)
				(poem setCursor: 990 2 2 yourself:)
				(tinderBox setCursor: 990 3 8 yourself:)
				(tomato setCursor: 990 3 9 yourself:)
				(sentence setCursor: 990 3 10 yourself:)
				(ink setCursor: 990 3 12 yourself:)
				(invLook cursor: cInvLook yourself:)
				(invHand cursor: cInvHand yourself:)
				(invSelect cursor: gNormalCursor yourself:)
				(invTalk cursor: cInvTalk yourself:)
				ok
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor (invWin back:)
			eachElementDo: #init
			window: invWin
			selectIcon: invSelect
			okButton: ok
		)
		(super init: &rest)
	)

	(method (advanceCurIcon &tmp temp0)
		(= temp0 curIcon)
		(while 1
			(while
				((= temp0 (self at: (mod (+ (self indexOf: temp0) 1) size)))
					isKindOf: InvI
				)
			)
			(breakif (!= (temp0 cursor:) -1))
		)
		(= curIcon temp0)
		(if (== curIcon helpIconItem)
			(curIcon signal: (| (curIcon signal:) $0010))
		else
			(curIcon signal: (& (curIcon signal:) $ffef))
		)
		(gGame setCursor: (curIcon cursor:))
	)

	(method (showSelf param1)
		(gTheIconBar disable:)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (gTheIconBar height:)
			(gTheIconBar hide:)
		)
		(if (not window)
			(= window (SysWindow new:))
		)
		(if (window window:)
			(window dispose:)
			(= window 0)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(if (not (& state $2000))
			(= curIcon 0)
		)
		(&= state $dfff)
		(if (self show: (if argc param1 else gEgo))
			(self doit:)
		else
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		)
	)
)

(instance invWin of Kq6Window
	(properties)

	(method (open &tmp temp0)
		(= temp0 (/ (CelHigh 901 3 0) 2))
		(-= top temp0)
		(+= bottom temp0)
		(super open: &rest)
	)
)

(instance boringBook of Kq6InvItem
	(properties
		message 42
		noun 1
		owner 270
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory hide:)
				(gCurRoom setScript: 88) ; boringBookScript
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance brick of Kq6InvItem
	(properties
		cel 1
		message 39
		noun 4
		owner 510
	)
)

(instance brush of Kq6InvItem
	(properties
		cel 2
		message 29
		noun 5
		owner 280
	)

	(method (cue)
		(= loop 3)
		(= cel 13)
		(++ state)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if state
					(gMessager say: noun theVerb 2 0 0 modNum) ; "The painter's brush now has residue from the magic paint left on the tip."
				else
					(gMessager say: noun theVerb 1 0 0 modNum) ; "Alexander is carrying a clean, but well-used, painter's brush."
				)
			)
			(5 ; Do
				(if state
					(gMessager say: noun theVerb 2 0 0 modNum) ; "The paint has already dried on the tip of the brush and is now useless."
				else
					(gMessager say: noun theVerb 1 0 0 modNum) ; "The paint brush bristles have softened to a perfect consistency after much hard use."
				)
			)
			(28 ; spellBook
				(if state
					(gMessager say: noun theVerb 2 0 0 modNum) ; "The "Make Paint Spell" must be used on the object Alexander painted, not on the dirty paint brush."
				else
					(gMessager say: noun theVerb 1 0 0 modNum) ; "The spell book would be useless on a clean paint brush!"
				)
			)
			(29 ; brush
				(gMessager say: noun theVerb 0 0 0 modNum) ; "There's no point in using an object on itself."
			)
			(44 ; teaCup
				(teaCup doVerb: message)
			)
			(else
				(if state
					(gMessager say: noun 0 2 0 0 modNum) ; "The paint has dried on the tip of the brush and leaves no impression behind."
				else
					(gMessager say: noun 0 1 0 0 modNum) ; "The clean paintbrush leaves no imprint on that."
				)
			)
		)
	)
)

(instance hair of Kq6InvItem
	(properties
		cel 15
		message 15
		noun 60
		owner 530
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; skull
				(skull doVerb: message)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clothes of Kq6InvItem
	(properties
		cel 4
		message 45
		noun 6
		owner 540
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (not (gEgo has: 4)) (not (IsFlag 93))) ; hair
					(KQ6Print
						font: gUserFont
						say: noun theVerb 0 0 0 0 modNum ; "It wouldn't be worthwhile to try and spice up the book by doing that."
						posn: -1 10
						init:
					)
					(KQ6Print
						font: gUserFont
						say: noun theVerb 36 0 0 0 modNum
						posn: -1 10
						init:
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(5 ; Do
				(if
					(or
						(IsFlag 143)
						(gEgo has: 4) ; hair
						(gEgo has: 16) ; cassimaHair
						(IsFlag 93)
					)
					(gMessager say: noun theVerb 34 0 0 modNum) ; "Alexander searches through Beauty's clothes but finds nothing."
				else
					(gInventory hide:)
					(SetFlag 143)
					(gEgo get: 4) ; hair
					(gGame givePoints: 1)
					(KQ6Print
						font: gUserFont
						say: noun theVerb 36 0 0 0 modNum
						posn: -1 10
						init:
					)
					(pageCode init: local1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance coal of Kq6InvItem
	(properties
		cel 5
		message 46
		noun 7
		owner 560
	)
)

(instance deadMansCoin of Kq6InvItem
	(properties
		cel 6
		message 7
		noun 9
		owner 430
	)
)

(instance dagger of Kq6InvItem
	(properties
		cel 7
		message 8
		noun 10
		owner 440
	)
)

(instance coin of Kq6InvItem
	(properties
		cel 8
		message 40
		noun 8
		owner 200
	)
)

(instance egg of Kq6InvItem
	(properties
		cel 9
		message 19
		noun 52
		owner 490
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; skull
				(skull doVerb: message)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skull of Kq6InvItem
	(properties
		loop 3
		cel 4
		message 51
		noun 63
		owner 415
	)

	(method (cue)
		(self loop: 3 cel: 4 setCursor: 990 3 4 state: (& (self state:) $fff7))
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
				(== (gTheIconBar curInvIcon:) self)
			)
			(cursor loop: 3 cel: 4)
			(gGame setCursor: cursor)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 18) ; cassimaHair
			(= theVerb 15) ; hair
		)
		(switch theVerb
			(20 ; tinderBox
				(if (& state $0004)
					(if (& state $0008)
						(gMessager say: noun 0 0 0 0 modNum) ; "There's no reason to use that on the skull."
					else
						(gMessager say: noun theVerb 37 0 0 modNum) ; "The oak embers have burnt into ash. There is no way to relight them."
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(28 ; spellBook
				(cond
					((not state)
						(gMessager say: noun theVerb 38 0 0 modNum) ; "There's no reason to cast a spell on an empty skull."
					)
					((and (& state $0004) (& state $0001) (& state $0002))
						(if
							(and
								(not (gCurRoom script:))
								(== (gEgo view:) 900)
							)
							(gInventory hide:)
							(gCurRoom setScript: 190) ; openBook
						else
							(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
						)
					)
					((and (& state $0004) (& state $fffe))
						(gMessager say: noun theVerb 39 0 0 modNum) ; "The book can only be used to cast spells over prepared spell ingredients. The ingredients in the skull are incomplete."
					)
					(
						(or
							(and (& state $0004) (& state $0001))
							(and (& state $0004) (& state $0002))
						)
						(gMessager say: noun theVerb 41 0 0 modNum) ; "!!!Do not print this. Comment msg only."
					)
				)
			)
			(15 ; hair
				(cond
					((not state)
						(gMessager say: noun 15 38 0 0 modNum) ; "There's no reason to put the hair into an empty skull."
					)
					((& state $0004)
						(gInventory hide:)
						(if (gEgo has: 4) ; hair
							(gEgo put: 4) ; hair
						else
							(gEgo put: 16) ; cassimaHair
						)
						(gGame givePoints: 1)
						(if (& state $0001)
							(KQ6Print
								font: gUserFont
								say: noun theVerb 41 0 0 0 modNum
								posn: -1 10
								init:
							)
						else
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 0 0 0 modNum ; "The brick would only get stuck in the hedges."
								posn: -1 10
								init:
							)
						)
						(|= state $0002)
						(pageCode init: local1)
					)
				)
			)
			(19 ; egg
				(cond
					((not state)
						(gMessager say: noun theVerb 38 0 0 modNum) ; "There's no reason to put the spoiled egg in the empty skull."
					)
					((and (& state $0004) (& state $0002))
						(gInventory hide:)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 40 1 0 0 modNum
							posn: -1 10
							init:
						)
						(if (& state $0008)
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 2 0 0 modNum
								posn: -1 10
								init:
							)
						else
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 3 0 0 modNum
								posn: -1 10
								init:
							)
						)
						(gEgo put: 10) ; egg
						(gGame givePoints: 1)
						(|= state $0001)
						(pageCode init: local1)
					)
					((& state $0004)
						(gInventory hide:)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 39 1 0 0 modNum
							posn: -1 10
							init:
						)
						(if (& state $0008)
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 2 0 0 modNum
								posn: -1 10
								init:
							)
						else
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 3 0 0 modNum
								posn: -1 10
								init:
							)
						)
						(gEgo put: 10) ; egg
						(gGame givePoints: 1)
						(|= state $0001)
						(pageCode init: local1)
					)
				)
			)
			(1 ; Look
				(cond
					((not state)
						(gMessager say: noun theVerb 38 0 0 modNum) ; "Alexander is carrying a human skull."
					)
					((and (& state $0004) (& state $0001) (& state $0002))
						(KQ6Print
							font: gUserFont
							say: noun theVerb 42 1 0 0 modNum ; "There's no point in using an object on itself."
							posn: -1 10
							init:
						)
						(if (& state $0008)
							(KQ6Print
								font: gUserFont
								say: noun theVerb 41 2 0 0 modNum
								posn: -1 10
								init:
							)
						else
							(KQ6Print
								font: gUserFont
								say: noun theVerb 41 3 0 0 modNum
								posn: -1 10
								init:
							)
						)
					)
					((and (& state $0004) (& state $0002))
						(KQ6Print
							font: gUserFont
							say: noun theVerb 40 1 0 0 modNum ; "Alexander grasps the coin of Daventry firmly and thinks of home."
							posn: -1 10
							init:
						)
						(if (& state $0008)
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 3 0 0 modNum
								posn: -1 10
								init:
							)
						else
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 2 0 0 modNum
								posn: -1 10
								init:
							)
						)
					)
					((and (& state $0004) (& state $0001))
						(KQ6Print
							font: gUserFont
							say: noun theVerb 41 1 0 0 modNum
							posn: -1 10
							init:
						)
						(if (& state $0008)
							(KQ6Print
								font: gUserFont
								say: noun theVerb 41 2 0 0 modNum
								posn: -1 10
								init:
							)
						else
							(KQ6Print
								font: gUserFont
								say: noun theVerb 41 3 0 0 modNum
								posn: -1 10
								init:
							)
						)
					)
					((& state $0004)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 39 1 0 0 modNum ; "The brick is already heavy enough to carry around without playing with it!"
							posn: -1 10
							init:
						)
						(if (& state $0008)
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 3 0 0 modNum
								posn: -1 10
								init:
							)
						else
							(KQ6Print
								font: gUserFont
								say: noun theVerb 39 2 0 0 modNum
								posn: -1 10
								init:
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance feather of Kq6InvItem
	(properties
		cel 11
		message 30
		noun 13
		owner 300
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; teaCup
				(teaCup doVerb: message)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flower of Kq6InvItem
	(properties
		cel 12
		message 47
		noun 14
		owner 300
	)
)

(instance flute of Kq6InvItem
	(properties
		cel 13
		message 31
		noun 15
		owner 280
	)
)

(instance gauntlet of Kq6InvItem
	(properties
		cel 14
		message 48
		noun 16
		owner 650
	)
)

(instance cassimaHair of Kq6InvItem
	(properties
		cel 3
		message 18
		noun 59
		owner 210
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; skull
				(skull doVerb: (hair message:))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance handkerchief of Kq6InvItem
	(properties
		loop 1
		message 50
		noun 18
		owner 680
	)
)

(instance holeInTheWall of Kq6InvItem
	(properties
		loop 1
		cel 1
		message 25
		noun 19
		owner 480
	)
)

(instance huntersLamp of Kq6InvItem
	(properties
		loop 1
		cel 2
		message 43
		noun 23
		owner 520
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: noun theVerb 0 0 0 0 modNum ; "It wouldn't be worthwhile to try and spice up the book by doing that."
					init:
				)
				(cond
					((== global161 0)
						(gMessager say: noun theVerb 4 0 0 modNum) ; "The lamp is empty."
					)
					((== global161 1)
						(gMessager say: noun theVerb 7 0 0 modNum) ; "The lamp contains fountain water."
					)
					((== global161 4)
						(gMessager say: noun theVerb 6 0 0 modNum) ; "The lamp contains baby's tears."
					)
					((== global161 6)
						(gMessager say: noun theVerb 8 0 0 modNum) ; "The lamp contains sacred water and baby's tears."
					)
					((== global161 5)
						(gMessager say: noun theVerb 12 0 0 modNum) ; "The lamp contains fountain water and baby's tears."
					)
					((== global161 15)
						(gMessager say: noun theVerb 10 0 0 modNum) ; "The lamp contains what Alexander hopes is the completed "Make Rain Spell.""
					)
					((== global161 7)
						(gMessager say: noun theVerb 9 0 0 modNum) ; "The lamp contains sacred water, baby's tears, and fountain water."
					)
					((== global161 2)
						(gMessager say: noun theVerb 5 0 0 modNum) ; "The lamp contains sacred water."
					)
					((== global161 3)
						(gMessager say: noun theVerb 11 0 0 modNum) ; "The lamp contains fountain water and sacred water."
					)
				)
			)
			(28 ; spellBook
				(cond
					((not (IsFlag 77))
						(gMessager say: noun theVerb 15 0 0 modNum) ; "Why would Alexander want to use the spell book on the hunter's lamp?"
					)
					((== global161 15)
						(gMessager say: noun theVerb 10 0 0 modNum) ; "The old hunter's lamp is already as "enchanted" as it's ever going to get!"
					)
					((== global161 0)
						(gMessager say: noun theVerb 4 0 0 modNum) ; "There's no reason to enchant the empty lamp."
					)
					((== global161 7)
						(if
							(and
								(not (gCurRoom script:))
								(== (gEgo view:) 900)
							)
							(gInventory hide:)
							(gCurRoom setScript: 190) ; openBook
						else
							(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
						)
					)
					(
						(or
							(== global161 (| global161 $0001))
							(== global161 (| global161 $0004))
							(== global161 (| global161 $0002))
						)
						(gMessager say: noun theVerb 14 0 0 modNum) ; "Spells must be cast over completely prepared spell ingredients. The lamp ingredients are not yet ready for enchantment."
					)
				)
			)
			(24 ; sacredWater
				(cond
					((not (IsFlag 77))
						(gMessager say: noun theVerb 15 0 0 modNum) ; "Alexander has no reason to pour the Oracle's water in the lamp."
					)
					((and (IsFlag 77) (== global161 1))
						(gMessager say: noun theVerb 18 0 0 modNum) ; "The old lamp is already full to the brim with fountain water. There's no room for the Oracle's water."
					)
					((and (IsFlag 77) (== global161 5))
						(gMessager say: noun theVerb 19 0 0 modNum) ; "The old lamp is already full to the brim with fountain water. There's no room for the Oracle's water."
					)
					((and (IsFlag 77) (== global161 0))
						(gInventory hide:)
						(gEgo put: 40) ; sacredWater
						(gGame givePoints: 1)
						(|= global161 $0002)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 16 0 0 0 modNum
							posn: -1 10
							init:
						)
						(gInventory curIcon: (gInventory selectIcon:))
						(gTheIconBar disable: 4)
						(pageCode init: local1)
					)
					((and (IsFlag 77) (== global161 4))
						(gInventory hide:)
						(gEgo put: 40) ; sacredWater
						(gGame givePoints: 1)
						(|= global161 $0002)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 17 0 0 0 modNum
							posn: -1 10
							init:
						)
						(pageCode init: local1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance letter of Kq6InvItem
	(properties
		loop 1
		cel 3
		message 61
		noun 29
		owner 780
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory hide:)
				(gCurRoom setScript: 101 self) ; readNote
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lettuce of Kq6InvItem
	(properties
		loop 1
		cel 4
		message 52
		noun 20
		owner 480
	)

	(method (cue)
		(switch state
			(0
				(= noun 21)
				(= message 53)
				(= cel 5)
				(self setCursor: 990 1 5)
				(if
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
						(== (gTheIconBar curInvIcon:) self)
					)
					(genericCursor view: 990 loop: cursorLoop cel: cursorCel)
					(gGame setCursor: genericCursor)
				)
				((ScriptID 0 7) setReal: (gInventory at: 21) 30 2) ; lettuceTimer, lettuce
				(++ state)
			)
			(1
				(= noun 22)
				(= message 54)
				(= cel 6)
				(self setCursor: 990 1 6)
				(if
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
						(== (gTheIconBar curInvIcon:) self)
					)
					(genericCursor view: 990 loop: cursorLoop cel: cursorCel)
					(gGame setCursor: genericCursor)
				)
				((ScriptID 0 7) setReal: (gInventory at: 21) 30 2) ; lettuceTimer, lettuce
				(++ state)
			)
			(2
				((ScriptID 0 7) dispose:) ; lettuceTimer
				(= noun 20)
				(= message 52)
				(= cel 4)
				(self setCursor: 990 1 4)
				(= state 0)
				(gEgo put: 21 480) ; lettuce
			)
		)
	)
)

(instance map of Kq6InvItem
	(properties
		loop 1
		cel 7
		message 12
		noun 31
		owner 280
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (OneOf gCurRoomNum 200 300 260 500 550 450)
				(gInventory hide:)
				(self cue:)
			else
				(gMessager say: 31 5 43 0 0 907) ; "Alexander remembers what the pawn shop owner said about only being able to use the map "out in the open" and "within sight of the sea." He correctly surmises that the map will not work here."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(if (== gCurRoomNum 450)
			(gCurRoom notify: 1)
		else
			((gEgo looper:) dispose:)
			(gEgo setMotion: 0 setCycle: 0)
			(gCurRoom setScript: 130) ; pullOutMapScr
		)
	)
)

(instance milk of Kq6InvItem
	(properties
		loop 1
		cel 8
		message 62
		noun 32
		owner 470
	)
)

(instance mint of Kq6InvItem
	(properties
		loop 1
		cel 9
		message 63
		noun 33
		owner 280
	)
)

(instance mirror of Kq6InvItem
	(properties
		loop 1
		cel 10
		message 13
		noun 34
		owner 540
	)
)

(instance newLamp of Kq6InvItem
	(properties
		loop 1
		cel 11
		message 57
		noun 25
		owner 240
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (not (== noun 66))
					(self hideInv: 1)
				)
				(super doVerb: theVerb &rest)
			)
			(24 ; sacredWater
				(self hideInv: 0)
				(if (IsFlag 77)
					(gMessager say: noun theVerb 21 0 0 modNum) ; "The "Make Rain Spell" calls for a teapot. That lamp has a handle, but neither a spout nor a lid. It's nothing like a teapot."
				else
					(gMessager say: 57 theVerb 15 0 0 modNum)
				)
			)
			(else
				(self hideInv: 0)
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nail of Kq6InvItem
	(properties
		loop 2
		message 64
		noun 35
	)
)

(instance nightingale of Kq6InvItem
	(properties
		loop 2
		cel 1
		message 37
		noun 55
		owner 280
	)
)

(instance ticket of Kq6InvItem
	(properties
		loop 3
		cel 7
		message 49
		noun 17
		owner 600
	)
)

(instance participle of Kq6InvItem
	(properties
		loop 5
		message 94
		noun 57
		owner 500
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(super doVerb: theVerb &rest)
		(if (not (OneOf theVerb 1 94 28 13 12)) ; Look, participle, spellBook, mirror, map
			(for ((= temp0 0)) (< temp0 20) ((++ temp0))
				(for ((= temp1 0)) (< temp1 7000) ((++ temp1))
				)
				(DrawCel 970 5 (Random 0 (- (NumCels self) 1)) nsLeft nsTop 15)
			)
		)
		(DrawCel 970 5 0 nsLeft nsTop 15)
	)
)

(instance pearl of Kq6InvItem
	(properties
		loop 2
		cel 4
		message 66
		noun 37
		owner 450
	)
)

(instance peppermint of Kq6InvItem
	(properties
		loop 2
		cel 5
		message 67
		noun 38
		owner 390
	)
)

(instance note of Kq6InvItem
	(properties
		loop 2
		cel 6
		message 65
		noun 36
		owner 210
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory hide:)
				(gCurRoom setScript: 96 self) ; readNote
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance potion of Kq6InvItem
	(properties
		loop 2
		cel 7
		message 14
		noun 12
		owner 480
	)
)

(instance rabbitFoot of Kq6InvItem
	(properties
		loop 2
		cel 8
		message 68
		noun 39
		owner 290
	)
)

(instance ribbon of Kq6InvItem
	(properties
		loop 2
		cel 10
		message 33
		noun 40
		owner 210
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (or (gEgo has: 4) (gEgo has: 16) (IsFlag 112)) ; hair, cassimaHair
					(gMessager say: noun theVerb 0 0 0 modNum) ; "The lady's hair ribbon is made of the finest red velvet."
				else
					(KQ6Print
						font: gUserFont
						posn: -1 10
						say: noun theVerb 0 0 0 0 907 ; "It wouldn't be worthwhile to try and spice up the book by doing that."
						init:
					)
					(KQ6Print
						font: gUserFont
						posn: -1 10
						say: noun theVerb 33 0 0 0 907
						init:
					)
				)
			)
			(5 ; Do
				(if
					(or
						(IsFlag 143)
						(gEgo has: 4) ; hair
						(gEgo has: 16) ; cassimaHair
						(IsFlag 112)
					)
					(gMessager say: noun theVerb 34 0 0 modNum) ; "The red ribbon feels soft and luxurious between Alexander's caressing fingers."
				else
					(gInventory hide:)
					(SetFlag 143)
					(gEgo get: 16) ; cassimaHair
					(gGame givePoints: 1)
					(KQ6Print
						font: gUserFont
						say: noun theVerb 33 0 0 0 modNum
						posn: -1 10
						init:
					)
					(pageCode init: local1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance riddleBook of Kq6InvItem
	(properties
		loop 2
		cel 11
		message 27
		noun 2
		owner 460
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gInventory hide:)
			(gCurRoom setScript: 90) ; beginScript
		else
			(self hideInv: 0)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ring of Kq6InvItem
	(properties
		loop 2
		cel 12
		message 69
		noun 41
		owner 540
	)

	(method (cue)
		(if
			(and
				(== (gEgo view:) 900)
				(User canControl:)
				(not (OneOf gCurRoomNum 580 390 320 300 270 490))
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: (ScriptID 84 0)) ; egoBeastScript
		else
			((ScriptID 0 5) setReal: self 10 0 0) ; beastTimer
		)
	)
)

(instance rose of Kq6InvItem
	(properties
		loop 2
		cel 13
		message 71
		noun 43
		owner 530
	)
)

(instance royalRing of Kq6InvItem
	(properties
		loop 2
		cel 14
		message 70
		noun 42
		owner 200
	)
)

(instance sacredWater of Kq6InvItem
	(properties
		loop 2
		cel 15
		message 24
		noun 56
		owner 380
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 43) ; huntersLamp
				(huntersLamp doVerb: message)
			)
			((OneOf 57 58 59 60 96 56)
				(newLamp doVerb: message)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance scarf of Kq6InvItem
	(properties
		loop 3
		message 72
		noun 45
		owner 490
	)
)

(instance scythe of Kq6InvItem
	(properties
		loop 3
		cel 1
		message 16
		noun 46
		owner 560
	)
)

(instance shield of Kq6InvItem
	(properties
		loop 3
		cel 2
		message 17
		noun 47
		owner 408
	)
)

(instance skeletonKey of Kq6InvItem
	(properties
		loop 3
		cel 3
		message 35
		noun 48
		owner 670
	)
)

(instance spellBook of Kq6InvItem
	(properties
		loop 3
		cel 5
		message 28
		noun 3
		owner 270
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (== (gEgo view:) 900) (not (gCurRoom script:)))
					(gInventory hide:)
					(gCurRoom setScript: 190) ; openBook
				else
					(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
				)
			)
			(43 ; huntersLamp
				(huntersLamp doVerb: message)
			)
			(51 ; skull
				(skull doVerb: message)
			)
			(44 ; teaCup
				(teaCup doVerb: message)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance teaCup of Kq6InvItem
	(properties
		loop 3
		cel 6
		message 44
		noun 53
		owner 480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(KQ6Print
					font: gUserFont
					say: noun theVerb 0 0 0 0 modNum ; "It wouldn't be worthwhile to try and spice up the book by doing that."
					posn: -1 10
					init:
				)
				(cond
					((IsFlag 23)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 32 0 0 0 modNum
							posn: -1 10
							init:
						)
					)
					((IsFlag 22)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 31 0 0 0 modNum ; "Alexander plays a lovely little tune on the flute."
							posn: -1 10
							init:
						)
					)
					(
						(and
							(not (IsFlag 68))
							(not (IsFlag 58))
							(not (IsFlag 22))
						)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 27 0 0 0 modNum
							posn: -1 10
							init:
						)
					)
					(
						(and
							(IsFlag 68)
							(not (IsFlag 58))
							(not (IsFlag 22))
						)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 28 0 0 0 modNum
							posn: -1 10
							init:
						)
					)
					((and (IsFlag 68) (IsFlag 58) (not (IsFlag 22)))
						(KQ6Print
							font: gUserFont
							say: noun theVerb 30 0 0 0 modNum ; "Alexander is 'tickled' enough just to be out on his own on this adventure!"
							posn: -1 10
							init:
						)
					)
					(
						(and
							(not (IsFlag 68))
							(IsFlag 58)
							(not (IsFlag 22))
						)
						(KQ6Print
							font: gUserFont
							say: noun theVerb 29 0 0 0 modNum ; "The paintbrush would not leave a lasting impression on Alexander."
							posn: -1 10
							init:
						)
					)
				)
			)
			(28 ; spellBook
				(cond
					((IsFlag 23)
						(gMessager say: noun theVerb 32 0 0 modNum) ; "There's nothing left in the cup worth enchanting. The "Make Paint Spell" must be used on the object Alexander painted."
					)
					((IsFlag 22)
						(gMessager say: noun theVerb 31 0 0 modNum) ; "To cast the "Magic Paint Spell," Alexander must first paint an object at a desired location, then use the spell book on the painted object to enchant it."
					)
					(
						(or
							(and
								(not (IsFlag 68))
								(not (IsFlag 58))
								(not (IsFlag 22))
							)
							(and
								(IsFlag 68)
								(not (IsFlag 58))
								(not (IsFlag 22))
							)
							(and
								(IsFlag 68)
								(IsFlag 58)
								(not (IsFlag 22))
							)
							(and
								(not (IsFlag 68))
								(IsFlag 58)
								(not (IsFlag 22))
							)
						)
						(gMessager say: noun theVerb 28 0 0 modNum) ; "Casting spells is done over prepared spell ingredients. That doesn't look like the completed ingredients to any spell that Alexander can recall."
					)
				)
			)
			(29 ; brush
				(cond
					((IsFlag 23)
						(gMessager say: noun theVerb 32 0 0 modNum) ; "The magic paint has been used up."
					)
					((IsFlag 22)
						(gMessager say: noun theVerb 31 0 0 modNum) ; "To paint something, Alexander must first choose a location where he wants to paint. The paint can then be used on that location."
					)
					(
						(and
							(not (IsFlag 68))
							(not (IsFlag 58))
							(not (IsFlag 22))
						)
						(gMessager say: noun theVerb 27 0 0 modNum) ; "There's no reason to use the clean paintbrush on the empty teacup."
					)
					(
						(or
							(and
								(IsFlag 68)
								(not (IsFlag 58))
								(not (IsFlag 22))
							)
							(and
								(IsFlag 68)
								(IsFlag 58)
								(not (IsFlag 22))
							)
							(and
								(not (IsFlag 68))
								(IsFlag 58)
								(not (IsFlag 22))
							)
						)
						(gMessager say: noun theVerb 28 0 0 modNum) ; "The 'paint' is not ready to be used yet."
					)
				)
			)
			(30 ; feather
				(cond
					(
						(and
							(not (IsFlag 68))
							(not (IsFlag 58))
							(not (IsFlag 22))
						)
						(gMessager say: noun theVerb 27 0 0 modNum) ; "The black feather would have little effect on an empty teacup."
					)
					(
						(or
							(and
								(IsFlag 68)
								(not (IsFlag 58))
								(not (IsFlag 22))
							)
							(and
								(not (IsFlag 68))
								(IsFlag 58)
								(not (IsFlag 22))
							)
						)
						(gMessager say: noun theVerb 28 0 0 modNum) ; "Alexander doesn't have all the paint ingredients in the cup yet. The spell isn't ready to be stirred."
					)
					((and (IsFlag 68) (IsFlag 58) (not (IsFlag 22)))
						(if
							(and
								(== (gEgo view:) 900)
								(not (gCurRoom script:))
							)
							(gCurRoom setScript: 915) ; mixPaintScr
						else
							(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poem of Kq6InvItem
	(properties
		loop 2
		cel 2
		message 32
		noun 30
		owner 270
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory hide:)
				(gCurRoom setScript: 97 self) ; readPoem
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tinderBox of Kq6InvItem
	(properties
		loop 3
		cel 8
		message 20
		noun 54
		owner 280
	)
)

(instance tomato of Kq6InvItem
	(properties
		loop 4
		message 34
		noun 44
		owner 480
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (not (OneOf theVerb 1 34)) ; Look, tomato
			(if (== theVerb 2) ; Talk
				(gMessager say: noun theVerb (Random 45 48) 0 0 907)
			else
				(super doVerb: theVerb &rest)
			)
			(if (not (OneOf theVerb 28 13 12)) ; spellBook, mirror, map
				(for ((= temp0 0)) (< temp0 25) ((++ temp0))
					(for ((= temp1 0)) (< temp1 7000) ((++ temp1))
					)
					(DrawCel
						970
						4
						(Random 0 (- (NumCels self) 1))
						nsLeft
						nsTop
						15
					)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
		(DrawCel 970 4 0 nsLeft nsTop 15)
	)
)

(instance sentence of Kq6InvItem
	(properties
		loop 3
		cel 10
		message 85
		noun 11
		owner 450
	)
)

(instance ink of Kq6InvItem
	(properties
		loop 3
		cel 12
		message 83
		noun 68
		owner 240
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 5) ; Look, Do
			(if (IsFlag 116)
				(gMessager say: noun theVerb 50 0 0 907)
			else
				(gMessager say: noun theVerb 0 0 0 907)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ok of IconI
	(properties
		view 901
		loop 3
		cel 0
		nsLeft 40
		signal 67
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: 44)
		(super init: &rest)
	)
)

(instance invLook of IconI
	(properties
		view 901
		loop 2
		cel 0
		message 1
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: 44)
		(super init: &rest)
	)
)

(instance invHand of IconI
	(properties
		view 901
		loop 0
		cel 0
		message 5
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: 44)
		(super init: &rest)
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: 44)
		(super init: &rest)
	)
)

(instance invTalk of IconI
	(properties
		view 901
		loop 5
		cel 0
		message 2
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: 44)
		(super init: &rest)
	)
)

(instance invMore of IconI
	(properties
		view 901
		loop 6
		cel 0
		lowlightColor 44
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(if (>= local0 13)
				(for ((= temp0 0)) (< temp0 52) ((++ temp0))
					(if (== ((= temp1 (gInventory at: temp0)) realOwner:) local1)
						(if (== (temp1 owner:) local1)
							(temp1 owner: 1)
						else
							(temp1 owner: local1)
						)
					)
				)
				(gInventory state: (| (gInventory state:) $2000))
				(gInventory
					hide: 1
					highlightedIcon: ok
					addAfter: invTalk invPrevious
					delete: invMore
					showSelf: local1
				)
				(return 0)
			else
				(gMessager say: 67 0 49 0 0 907) ; "This is the only page of inventory."
				(return 0)
			)
		)
	)
)

(instance invPrevious of IconI
	(properties
		view 901
		loop 7
		cel 0
		lowlightColor 44
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(for ((= temp0 0)) (< temp0 52) ((++ temp0))
				(if (== ((= temp1 (gInventory at: temp0)) realOwner:) local1)
					(if (== (temp1 owner:) 1)
						(temp1 owner: local1)
					else
						(temp1 owner: 0)
					)
				)
			)
			(gInventory state: (| (gInventory state:) $2000))
			(gInventory
				hide: 1
				highlightedIcon: ok
				addAfter: invTalk invMore
				delete: invPrevious
				showSelf: local1
			)
			(return 0)
		)
	)
)

(instance cInvLook of Cursor
	(properties
		view 998
		loop 1
		cel 1
	)
)

(instance cInvHand of Cursor
	(properties
		view 998
		loop 1
		cel 2
	)
)

(instance cInvTalk of Cursor
	(properties
		view 998
		loop 1
		cel 3
	)
)

(instance genericCursor of Cursor
	(properties)
)

