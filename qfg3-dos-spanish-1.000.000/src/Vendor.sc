;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use GameControls)
(use System)

(public
	Vendor 0
	Class_47_1 1
	barter 2
	proc47_3 3
)

(local
	local0
	[local1 4] = [3 128 3 128]
	[local5 4] = [18 18 36 36]
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	[local25 30]
	[local55 30]
	local85
	local86
)

(procedure (localproc_0)
	(Message msgGET 47 10 0 0 1 @local55) ; "The current price for the"
	(Display @local55 dsCOORD 3 22 dsCOLOR 1 dsFONT (proc0_21 1000 1000 1000 1000 123))
	(Message msgGET 47 10 0 0 2 @local55) ; "%s is %d%s"
	(Display
		(Format
			@local25
			@local55
			((local13 cursor:) name:)
			local12
			((local13 cursor:) symbol:)
		)
		dsCOORD
		3
		37
		dsCOLOR
		1
		dsFONT
		(proc0_21 1000 1000 1000 1000 123)
	)
)

(procedure (localproc_1 &tmp temp0)
	(= temp0 0)
	(if (& local9 $0001)
		(Display @temp0 dsRESTOREPIXELS local17)
	else
		(if local17
			(Display @temp0 dsRESTOREPIXELS local17)
		)
		(if (== local11 1)
			(Message msgGET 47 9 0 0 1 @local55) ; "It will cost you %d%s."
			(= local17
				(Display
					(Format @local25 @local55 local12 ((local13 cursor:) symbol:))
					dsCOORD
					3
					73
					dsCOLOR
					1
					dsFONT
					(proc0_21 1000 1000 1000 1000 123)
					dsSAVEPIXELS
				)
			)
		else
			(Message msgGET 47 9 0 0 2 @local55) ; "They will cost you %d%s."
			(= local17
				(Display
					(Format
						@local25
						@local55
						(* local11 local12)
						((local13 cursor:) symbol:)
					)
					dsCOORD
					3
					73
					dsCOLOR
					1
					dsFONT
					(proc0_21 1000 1000 1000 1000 123)
					dsSAVEPIXELS
				)
			)
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(if local16
		(= temp0 0)
		(Display @temp0 dsRESTOREPIXELS local16)
	)
	(if ((gInventory at: 0) amount:) ; theRoyals
		(if global410
			(Message msgGET 47 8 0 0 2 @local55) ; "You have %dR and %dc."
			(= local16
				(Display
					(Format @local25 @local55 ((gInventory at: 0) amount:) global410) ; theRoyals
					dsCOORD
					3
					57
					dsCOLOR
					1
					dsFONT
					(proc0_21 1000 1000 1000 1000 123)
					dsSAVEPIXELS
				)
			)
		else
			(Message msgGET 47 8 0 0 1 @local55) ; "You have %dR."
			(= local16
				(Display
					(Format @local25 @local55 ((gInventory at: 0) amount:)) ; theRoyals
					dsCOORD
					3
					57
					dsCOLOR
					1
					dsFONT
					(proc0_21 1000 1000 1000 1000 123)
					dsSAVEPIXELS
				)
			)
		)
	else
		(Message msgGET 47 8 0 0 3 @local55) ; "You have %dc."
		(= local16
			(Display
				(Format @local25 @local55 global410)
				dsCOORD
				3
				57
				dsCOLOR
				1
				dsFONT
				(proc0_21 1000 1000 1000 1000 123)
				dsSAVEPIXELS
			)
		)
	)
	(if local19
		(cond
			(local18
				(= local18 0)
			)
			(local22
				(= local22 0)
			)
			(else
				(barter eachElementDo: #show)
			)
		)
	else
		(= local19 1)
	)
)

(procedure (localproc_3)
	(localproc_0)
	(quantityIcon show:)
)

(procedure (localproc_4)
	(localproc_1)
	(quantityIcon show:)
)

(procedure (localproc_5)
	(cond
		((== ((local13 cursor:) denomination:) 100)
			(if
				(>=
					(+ (/ global410 100) ((gInventory at: 0) amount:)) ; theRoyals
					(* local12 local11)
				)
				(return 1)
			else
				(return 0)
			)
		)
		((>= global410 (* local12 local11))
			(return 1)
		)
		(
			(>=
				(+ (* ((gInventory at: 0) amount:) 100) global410) ; theRoyals
				(* local12 local11)
			)
			(return 1)
		)
		(else
			(return 0)
		)
	)
)

(procedure (proc47_3 param1 param2 &tmp temp0 temp1 [temp2 20])
	(= local0 1)
	(gLongSong3 number: 260 setLoop: 4 play:)
	(= temp1 (gInventory at: 0)) ; theRoyals
	(= temp0 ((local15 goods:) at: param1))
	(cond
		((== (temp0 denomination:) 100)
			(if (<= (* (temp0 price:) param2) (temp1 amount:))
				(temp1 amount: (- (temp1 amount:) (* (temp0 price:) param2)))
			else
				(+= global410 (* (temp1 amount:) 100))
				(temp1 amount: 0)
				(-= global410 (* (temp0 price:) param2 100))
			)
		)
		((<= (* (temp0 price:) param2) global410)
			(-= global410 (* (temp0 price:) param2))
		)
		(else
			(while (> (* (temp0 price:) param2) global410)
				(+= global410 100)
				(temp1 amount: (- (temp1 amount:) 1))
			)
			(-= global410 (* (temp0 price:) param2))
		)
	)
	(((local15 goods:) at: param1)
		quantity: (- (((local15 goods:) at: param1) quantity:) param2)
	)
	(if (and (temp1 amount:) (== (temp1 message:) 59))
		(temp1 message: 10)
	)
	(if
		(and
			(not global410)
			(not (temp1 amount:))
			global424
			(== (temp1 message:) 10)
		)
		(temp1 message: 59)
	)
)

(class Vendor of Obj
	(properties
		goods 0
		timesBargained 0
		prevBargain 0
		discount 0
		header 0
		script 0
		noun 0
	)

	(method (init &tmp temp0)
		(if (IsObject gCollect)
			(gCollect add: self)
		else
			((= gCollect (Collect new:)) add: self)
		)
		(= temp0 (Message msgSIZE gCurRoomNum noun 0 0 1))
		(= header (Memory memALLOC_NONCRIT temp0))
		(Message msgGET gCurRoomNum noun 0 0 1 header)
	)

	(method (cue &tmp temp0)
		(if local0
			(= local0 0)
			(= local22 1)
			(if (> local11 1)
				(gMessager say: 11 6 2 0 self 47) ; "You pay for your purchases and put them away in your backpack."
			else
				(gMessager say: 11 6 3 0 self 47) ; "You pay for it and put it away in your pack."
			)
		else
			(gGame setCursor: 999)
			(= local21 0)
			(if (& local9 $0001)
				(= local11 1)
			)
			(if (and (& local9 $0004) local18)
				(= local9 2)
			)
			(if (and (not ((local13 cursor:) quantity:)) (== local23 1))
				(barter state: (& (barter state:) $ffdf))
			else
				(barter show:)
			)
		)
	)

	(method (purchase)
		(barter init: self dispose:)
		(return (not local86))
	)

	(method (canStillBargain)
		(switch (local13 message:)
			(0
				(return (not (& prevBargain $0001)))
			)
			(1
				(return (not (& prevBargain $0002)))
			)
			(2
				(return (not (& prevBargain $0004)))
			)
			(3
				(return (not (& prevBargain $0008)))
			)
		)
	)

	(method (bargain param1 &tmp temp0 temp1 temp2 temp3)
		(switch param1
			(0
				(|= prevBargain $0001)
			)
			(1
				(|= prevBargain $0002)
			)
			(2
				(|= prevBargain $0004)
			)
			(3
				(|= prevBargain $0008)
			)
		)
		(if (== [gEgoStats 13] 550) ; communication
			(= temp0 550)
		else
			(= temp0 (/ (* [gEgoStats 13] (- 100 (* 10 timesBargained))) 100)) ; communication
		)
		(if (< temp0 100)
			(= temp0 100)
		)
		(++ timesBargained)
		(= temp1 ((goods at: param1) price:))
		(= temp2 (/ (* (- 100 (/ (- temp0 100) 4)) temp1) 100))
		(cond
			((>= local10 temp2)
				((goods at: param1) price: local10)
				(= local12 local10)
				(= local18 1)
				(= local20 0)
				(self doBargain: 1 param1)
			)
			((>= local10 (/ temp2 2))
				((goods at: param1) price: (- temp1 (/ (- temp1 temp2) 4)))
				(= local12 (= local10 ((goods at: param1) price:)))
				(switch (mod (+ timesBargained 2) 3)
					(0
						(self doBargain: 2 param1)
					)
					(1
						(self doBargain: 3 param1)
					)
					(2
						(self doBargain: 4 param1)
					)
				)
			)
			((>= local10 (/ temp2 4))
				(= local18 1)
				(= local20 0)
				(self doBargain: 5 param1)
			)
			(else
				(= local18 1)
				(= local20 0)
				(self doBargain: 6 param1)
			)
		)
	)

	(method (transact))

	(method (doBargain))

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (dispose)
		(if (IsObject gCollect)
			(gCollect delete: self)
		)
		(if goods
			(goods dispose:)
		)
		(if (and noun header)
			(Memory memFREE header)
		)
		(super dispose:)
	)
)

(class Class_47_1
	(properties
		dynamicName 0
		price 0
		quantity 0
		denomination 100
		symbol 0
	)

	(method (dispose)
		(DisposeClone self)
		(if dynamicName
			(Memory memFREE name)
		)
		(Memory memFREE symbol)
	)

	(method (new param1 &tmp temp0 temp1 temp2)
		(= temp0 (Clone self))
		(if argc
			(temp0 dynamicName: 1)
			(= temp1 (Message msgSIZE gCurRoomNum param1 38 0 1))
			(temp0 name: (Memory memALLOC_NONCRIT temp1))
			(Message msgGET gCurRoomNum param1 38 0 1 (temp0 name:))
		)
		(temp0 symbol: (Memory memALLOC_NONCRIT 2))
		(return temp0)
	)

	(method (yourself)
		(return self)
	)
)

(instance barter of GameControls
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= local85 (gGame setCursor: 999))
		(= local19 0)
		(= window barterWin)
		(= local11 1)
		(= local9 1)
		(= local15 param1)
		(= local13 0)
		(= temp2 (local15 goods:))
		(if (not (= temp1 (temp2 size:)))
			(&= state $ffdf)
		)
		(= local23 0)
		(= temp0 0)
		(= temp4 0)
		(while (< temp0 temp1)
			(= temp3 (temp2 at: temp0))
			(if (temp3 quantity:)
				(self
					add:
						((barterIcon new:)
							nsLeft: [local1 temp4]
							nsRight: (+ [local1 temp4] 119)
							nsTop: [local5 temp4]
							nsBottom: (+ [local5 temp4] 16)
							message: temp0
							cursor: temp3
							yourself:
						)
				)
				(++ local23)
				(if (== (temp3 denomination:) 1)
					(Message msgGET 47 0 0 10 1 (temp3 symbol:)) ; "c"
				else
					(Message msgGET 47 0 0 9 1 (temp3 symbol:)) ; "R"
				)
				(++ temp4)
			)
			(++ temp0)
		)
		(if (== local23 1)
			(= local24 1)
		else
			(= local24 0)
		)
		(if size
			(self
				add:
					acceptIcon
					bargainIcon
					refuseIcon
					addToIcon
					subtractIcon
					quantityIcon
					dummyIcon
			)
			(super init: &rest)
			(= local9 1)
			(self show:)
		else
			(= local86 1)
			(return 0)
		)
	)

	(method (hide)
		(if (or (& local9 $0004) (& local9 $0002))
			(if window
				(window dispose:)
			)
		else
			(super hide:)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(cond
			(local21
				(if gFastCast
					(gFastCast eachElementDo: #doit)
					(if (and ((= temp0 (Event new:)) type:) gFastCast)
						(gFastCast firstTrue: #handleEvent temp0)
					)
					(temp0 dispose:)
					(gTheDoits doit:)
				else
					(= gGameTime (GetTime))
					(if (local15 script:)
						((local15 script:) doit:)
					)
					(Animate (gCast elements:) 1)
					(if gDoMotionCue
						(gCast eachElementDo: #motionCue)
					)
				)
			)
			((and (& local9 $0004) (== (event message:) KEY_ESCAPE))
				(barter hide:)
				(event dispose:)
				(= local18 1)
				(local15 cue:)
			)
			((!= (event message:) KEY_ESCAPE)
				(super dispatchEvent: event &rest)
			)
		)
	)

	(method (show &tmp [temp0 5])
		(if (& local9 $0003)
			(window top: 25 left: 35 right: 284 bottom: 136)
		else
			(window top: 25 left: 33 right: 286 bottom: 100)
		)
		(if local19
			(window open:)
			(self eachElementDo: #show)
		else
			(super show:)
		)
	)

	(method (advance &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((= temp1 (mod (+ temp1 1) size)))
			(= temp0
				(self at: (mod (+ temp1 (self indexOf: highlightedIcon)) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(if (!= temp0 dummyIcon)
				(breakif (not (& (temp0 signal:) $0004)))
			)
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (retreat &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((= temp1 (mod (+ temp1 1) size)))
			(= temp0
				(self at: (mod (- (self indexOf: highlightedIcon) temp1) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(if (!= temp0 dummyIcon)
				(breakif (not (& (temp0 signal:) $0004)))
			)
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(if (== temp1 256)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(temp0 localize:)
			(MapKeyToDir temp0)
			(breakif (or (not (& state $0020)) (self dispatchEvent: temp0)))
			(if gSet
				(gSet eachElementDo: #doit)
			)
		)
	)

	(method (dispose)
		(gGame setCursor: local85)
		(super dispose:)
	)
)

(instance barterIcon of IconI
	(properties
		view 939
		loop 0
		cel 0
		cursor 0
		message 0
		signal 257
	)

	(method (onMe)
		(return (and (& local9 $0001) (not local21) (super onMe: &rest)))
	)

	(method (show &tmp temp0)
		(if (cursor quantity:)
			(if (and local24 (not modifiers))
				(= local9 2)
				(= modifiers 1)
				(= local13 self)
				(= local20 (local15 canStillBargain:))
				(= local12 (= local10 ((local13 cursor:) price:)))
				(barter advance:)
			)
			(cond
				((& local9 $0001)
					(&= signal $fffb)
					(self highlight: 0)
				)
				((and (& local9 $0002) modifiers)
					(self highlight: 1)
					(|= signal $0004)
					(localproc_1)
				)
				(else
					(|= signal $0004)
					(self highlight: 1)
				)
			)
		else
			(barter delete: self)
			(-- local23)
			(for ((= temp0 0)) (< temp0 local23) ((++ temp0))
				((barter at: temp0)
					nsLeft: [local1 temp0]
					nsRight: (+ [local1 temp0] 119)
					nsTop: [local5 temp0]
					nsBottom: (+ [local5 temp0] 16)
				)
			)
			(self dispose:)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 [temp3 10])
		(if (not (& local9 $0004))
			(cond
				((& local9 $0001)
					(= temp1 0)
					(= temp2 0)
					(if param1
						(= temp0 46)
					else
						(= temp0 1)
					)
				)
				((& local9 $0002)
					(if modifiers
						(= temp1 1)
						(= temp0 46)
						(= temp2 0)
					else
						(= temp1 0)
						(= temp0 1)
						(= temp2 1)
					)
				)
			)
			(DrawCel view loop temp1 nsLeft nsTop 15)
			(Message msgGET 47 12 0 6 1 @temp3) ; "%s %d%s"
			(Display
				(Format
					@local25
					@temp3
					(cursor name:)
					(cursor price:)
					(cursor symbol:)
				)
				dsCOORD
				(+ nsLeft 1)
				(+ nsTop (proc0_21 4 4 4 4 3))
				dsCOLOR
				temp0
				dsWIDTH
				118
				dsALIGN
				alCENTER
				dsFONT
				(proc0_21 1000 1000 1000 1000 123)
				dsDISABLED
				temp2
			)
		)
	)

	(method (select)
		(= local9 2)
		(= modifiers 1)
		(= local13 self)
		(= local20 (local15 canStillBargain:))
		(= local12 (= local10 ((local13 cursor:) price:)))
		(localproc_2)
		(barter advance:)
	)
)

(instance acceptIcon of IconI
	(properties
		view 939
		loop 1
		cel 0
		signal 257
	)

	(method (show)
		(cond
			((or (& local9 $0001) (& local9 $0004))
				(|= signal $0004)
			)
			((IsObject local13)
				(if (and (not (localproc_5)) (& local9 $0002))
					(|= signal $0004)
				else
					(&= signal $fffb)
				)
			)
		)
		(= nsLeft 3)
		(= nsTop 91)
		(= nsBottom (+ nsTop 16))
		(= nsRight (+ nsLeft 77))
		(if (not (and (& local9 $0004) (& signal $0004)))
			(self highlight: 0)
		)
	)

	(method (onMe)
		(return
			(and
				(& local9 $0002)
				(not local21)
				(not (& signal $0004))
				(super onMe: &rest)
			)
		)
	)

	(method (highlight param1 &tmp temp0 temp1)
		(if (not local21)
			(if param1
				(= temp0 46)
			else
				(= temp0 1)
			)
			(if (or (& local9 $0001) (& signal $0004))
				(= temp1 1)
			else
				(= temp1 0)
			)
			(DrawCel view loop cel nsLeft nsTop 15)
			(Message msgGET 47 4 0 0 1 @local55) ; "Purchase"
			(Display
				@local55
				dsCOORD
				(+ nsLeft 1)
				(+ nsTop (proc0_21 4 4 4 4 3))
				dsCOLOR
				temp0
				dsWIDTH
				80
				dsALIGN
				alCENTER
				dsFONT
				(proc0_21 1000 1000 1000 1000 123)
				dsDISABLED
				temp1
			)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(local13 modifiers: 0)
			(= local21 1)
			(barter hide:)
			(= local9 1)
			(local15 transact: (local13 message:) local11)
		)
	)
)

(instance bargainIcon of IconI
	(properties
		view 939
		loop 1
		cel 0
		signal 257
	)

	(method (show)
		(if (or (& local9 $0001) (not local20))
			(|= signal $0004)
		else
			(&= signal $fffb)
		)
		(if (& local9 $0004)
			(= nsTop 55)
			(= nsLeft 88)
		else
			(= nsTop 91)
			(= nsLeft 86)
		)
		(= nsBottom (+ nsTop 16))
		(= nsRight (+ nsLeft 77))
		(self highlight: 0)
	)

	(method (onMe)
		(return
			(and
				(or (& local9 $0002) (& local9 $0004))
				local20
				(not local21)
				(super onMe: &rest)
			)
		)
	)

	(method (highlight param1 &tmp temp0 temp1)
		(if (not local21)
			(if param1
				(= temp0 46)
			else
				(= temp0 1)
			)
			(if (or (not local20) (& local9 $0001))
				(= temp1 1)
			else
				(= temp1 0)
			)
			(DrawCel view loop cel nsLeft nsTop 15)
			(if (& local9 $0004)
				(Message msgGET 47 5 0 0 1 @local55) ; "Make Offer"
			else
				(Message msgGET 47 5 0 0 2 @local55) ; "Bargain"
			)
			(Display
				@local55
				dsCOORD
				(+ nsLeft 2)
				(+ nsTop (proc0_21 4 4 4 4 3))
				dsCOLOR
				temp0
				dsWIDTH
				80
				dsALIGN
				alCENTER
				dsFONT
				(proc0_21 1000 1000 1000 1000 123)
				dsDISABLED
				temp1
			)
		)
	)

	(method (select)
		(cond
			((not (super select: &rest)) 0)
			((& local9 $0002)
				(local15 timesBargained: 0)
				(= local9 4)
				(barter hide:)
				(local15 cue:)
			)
			((& local9 $0004)
				(barter hide:)
				(= local21 1)
				(gEgo useSkill: 13 25) ; communication
				(local15 bargain: (local13 message:) local10)
			)
		)
	)
)

(instance refuseIcon of IconI
	(properties
		view 939
		loop 1
		cel 0
		signal 257
	)

	(method (onMe)
		(return (and (not local21) (super onMe: &rest)))
	)

	(method (show)
		(if (& local9 $0004)
			(= nsLeft 172)
			(= nsTop 55)
		else
			(= nsLeft 169)
			(= nsTop 91)
		)
		(= nsBottom (+ nsTop 16))
		(= nsRight (+ nsLeft 77))
		(self highlight: 0)
	)

	(method (highlight param1 &tmp temp0 [temp1 20])
		(if param1
			(= temp0 46)
		else
			(= temp0 1)
		)
		(if (and (& local9 $0002) (> local23 1))
			(Message msgGET 47 6 0 4 1 @local55) ; "New Item"
		else
			(Message msgGET 47 6 0 0 1 @local55) ; "No Thanks"
		)
		(DrawCel view loop cel nsLeft nsTop 15)
		(Display
			@local55
			dsCOORD
			(+ nsLeft 1)
			(+ nsTop (proc0_21 4 4 4 4 3))
			dsCOLOR
			temp0
			dsWIDTH
			80
			dsALIGN
			alCENTER
			dsFONT
			(proc0_21 1000 1000 1000 1000 123)
		)
	)

	(method (select &tmp temp0)
		(cond
			((not (super select: &rest)) 0)
			((& local9 $0001)
				(barter state: (& (barter state:) $ffdf))
			)
			((& local9 $0002)
				(if local24
					(barter state: (& (barter state:) $ffdf))
				else
					(local13 modifiers: 0)
					(= local9 1)
					(= local11 1)
					(localproc_1)
					(localproc_2)
					(self highlight: 1)
				)
			)
			((& local9 $0004)
				(barter hide:)
				(= local10 local12)
				(if (not (local15 canStillBargain:))
					(= local20 0)
				)
				(= local18 1)
				(local15 cue:)
			)
		)
	)
)

(instance addToIcon of IconI
	(properties
		view 939
		loop 2
		cel 0
		signal 257
	)

	(method (show)
		(if (& local9 $0001)
			(|= signal $0004)
		else
			(&= signal $fffb)
		)
		(if (& local9 $0004)
			(= nsLeft 237)
			(= nsTop 23)
		else
			(= nsLeft 233)
			(= nsTop 59)
		)
		(= nsBottom (+ nsTop 11))
		(= nsRight (+ nsLeft 12))
		(self highlight: 0)
	)

	(method (onMe)
		(return
			(and
				(or (& local9 $0002) (& local9 $0004))
				(not local21)
				(super onMe: &rest)
			)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (or (& local9 $0002) (& local9 $0004))
			(if param1
				(quantityIcon highlight: 1)
			else
				(quantityIcon highlight: 0)
			)
		)
		(DrawCel view loop cel nsLeft nsTop 15)
	)

	(method (select)
		(cond
			((not (super select: &rest))
				(self highlight: 0)
			)
			((& local9 $0002)
				(if (< local11 ((local13 cursor:) quantity:))
					(++ local11)
					(if (localproc_5)
						(localproc_4)
					else
						(-- local11)
					)
					(self highlight: 1)
				)
			)
			((& local9 $0004)
				(if (< local10 (* 3 local12))
					(++ local10)
				)
				(self highlight: 1)
			)
		)
	)
)

(instance subtractIcon of IconI
	(properties
		view 939
		loop 3
		cel 0
		signal 257
	)

	(method (show)
		(if (& local9 $0001)
			(|= signal $0004)
		else
			(&= signal $fffb)
		)
		(if (& local9 $0004)
			(= nsLeft 237)
			(= nsTop 37)
		else
			(= nsLeft 233)
			(= nsTop 73)
		)
		(= nsBottom (+ nsTop 11))
		(= nsRight (+ nsLeft 12))
		(self highlight: 0)
	)

	(method (onMe)
		(return
			(and
				(or (& local9 $0002) (& local9 $0004))
				(not local21)
				(super onMe: &rest)
			)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (or (& local9 $0002) (& local9 $0004))
			(if param1
				(quantityIcon highlight: 1)
			else
				(quantityIcon highlight: 0)
			)
		)
		(DrawCel view loop cel nsLeft nsTop 15)
	)

	(method (select)
		(cond
			((not (super select: &rest))
				(self highlight: 0)
			)
			((& local9 $0002)
				(if (> local11 1)
					(-- local11)
					(localproc_4)
				)
				(self highlight: 1)
			)
			((& local9 $0004)
				(if (> local10 1)
					(-- local10)
				)
				(self highlight: 1)
			)
		)
	)
)

(instance quantityIcon of IconI
	(properties
		view 939
		loop 4
		cel 0
		signal 261
	)

	(method (show)
		(self highlight: 0)
	)

	(method (onMe)
		(return 0)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 [temp3 10])
		(if (and (& local9 $0004) (not local18))
			(= nsLeft 165)
			(= nsTop 21)
		else
			(= nsLeft 160)
			(= nsTop 57)
		)
		(= nsBottom (+ nsTop 28))
		(= nsRight (+ nsLeft 70))
		(if param1
			(= temp0 46)
		else
			(= temp0 1)
		)
		(if (& local9 $0001)
			(= temp1 1)
		else
			(= temp1 0)
		)
		(DrawCel view loop cel nsLeft nsTop 15)
		(if (& local9 $0004)
			(Message msgGET 47 7 0 5 1 @local55) ; "Your Offer?"
			(= temp2 local10)
		else
			(Message msgGET 47 7 0 0 1 @local55) ; "Quantity"
			(= temp2 local11)
		)
		(Display
			@local55
			dsCOORD
			(+ nsLeft 1)
			(+ nsTop (proc0_21 4 4 4 4 3))
			dsCOLOR
			1
			dsWIDTH
			70
			dsALIGN
			alCENTER
			dsFONT
			(proc0_21 999 999 999 1000 999)
			dsDISABLED
			temp1
		)
		(Message msgGET 47 12 0 7 1 @temp3) ; "%d"
		(Display
			(Format @local25 @temp3 temp2)
			dsCOORD
			(+ nsLeft 1)
			(+ nsTop (proc0_21 1 1 1 1 3))
			dsCOLOR
			temp0
			dsWIDTH
			70
			dsALIGN
			alCENTER
			dsFONT
			(proc0_21 999 999 999 1000 999)
			dsDISABLED
			temp1
		)
	)
)

(instance dummyIcon of IconI
	(properties
		view 939
		loop 0
		cel 0
		nsTop 0
		nsRight 249
	)

	(method (show)
		(= nsBottom (barterWin bottom:))
	)

	(method (highlight))

	(method (select))
)

(instance barterWin of GloryWindow
	(properties)

	(method (open &tmp [temp0 10])
		(super open: &rest)
		(Graph grFILL_BOX 0 0 (- (- bottom top) 3) (- (- right left) 3) 1 back -1)
		(Graph grDRAW_LINE 16 0 16 (+ (- right left) 2) 58 -1 -1)
		(if (or (& local9 $0002) (& local9 $0001))
			(Graph grDRAW_LINE 54 0 54 (+ (- right left) 2) 58 -1 -1)
		)
		(Graph grUPDATE_BOX 0 0 (- (- bottom top) 3) (- (- right left) 2) 1)
		(Message msgGET 47 12 0 8 1 @temp0) ; "%s"
		(Display
			(Format @local25 @temp0 (local15 header:))
			dsCOORD
			0
			(proc0_21 4 4 4 4 1)
			dsCOLOR
			1
			dsWIDTH
			249
			dsALIGN
			alCENTER
			dsFONT
			(proc0_21 1000 1000 1000 1000 123)
		)
		(if (& local9 $0004)
			(localproc_3)
		else
			(localproc_2)
		)
	)
)

