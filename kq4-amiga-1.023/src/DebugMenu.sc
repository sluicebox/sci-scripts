;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Inventory)
(use Menu)
(use System)

(public
	DebugMenu 0
)

(instance DebugMenu of Script
	(properties)

	(method (init)
		(AddMenu
			{ Debug }
			{Ego info...`@e:Show Room`@R:Free Mem`@F:Show ATPs`@P:-! :Set Debug`^D:Clicks:Set Inv`@S:Set Var`@V:Get All`@G:Log`@L:-! :Visual`#0:Priority`#6:Control`#4}
		)
		(if (not (SL state:))
			(TheMenuBar draw:)
		)
	)

	(method (doit param1 &tmp temp0 [temp1 6] [temp7 33])
		(switch param1
			(1537
				(Print
					(Format ; "x: %d y: %d pri: %d"
						@global228
						801
						0
						(gEgo x:)
						(gEgo y:)
						(gEgo priority:)
					)
					#icon
					(gEgo view:)
					(gEgo loop:)
					(gEgo cel:)
				)
			)
			(1538
				(Print (Format @temp7 801 1 gCurRoomNum)) ; "This is room %d."
			)
			(1539
				(gGame showMem:)
			)
			(1540
				(gAddToPics showSelf:)
			)
			(1542
				(= gDebugOn 1)
			)
			(1543
				(if (^= global215 $0001)
					(Print 801 2) ; "NOW Ctrl-Click!"
				)
			)
			(1544
				(= global228 0)
				(GetInput @global228 8 {Inv. Object})
				(= global111 (ReadNumber @global228))
				(= global228 0)
				(GetInput @global228 12 {Owner})
				(if (not (StrCmp {ego} @global228))
					((gInventory at: global111) moveTo: gEgo)
				else
					((gInventory at: global111) moveTo: (ReadNumber @global228))
				)
				(= global228 0)
			)
			(1545
				(= global228 0)
				(GetInput @global228 8 {Variable No.})
				(= global111 (ReadNumber @global228))
				(= global228 0)
				(GetInput @global228 8 {Value})
				(= [gNight (- global111 100)] (ReadNumber @global228))
				(= global228 0)
			)
			(1546
				(gInventory eachElementDo: #moveTo gEgo)
				((Inv at: 14) loop: 0 cel: 0) ; Cupid_s_Bow
			)
			(1547
				(if (not global196)
					(if (< (= global195 (FOpen {KQ4QA.LOG} 0)) 0)
						(Print 801 3) ; "Failed to open KQ4.LOG"
					else
						(= global196 1)
						(Print 801 4) ; "Starting logfile entries."
						(FPuts global195 {New entries start here.\0d\n})
					)
				else
					(Print 801 5) ; "Logfile IS on."
				)
			)
			(1549
				(Show 1)
			)
			(1550
				(Show 2)
			)
			(1551
				(Show 4)
				(Animate (gCast elements:))
				(while (== 0 ((= temp0 (Event new: 32765)) type:))
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(Show 1)
			)
		)
	)
)

