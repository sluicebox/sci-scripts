;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	insideReg 0
)

(local
	[local0 76] = [210 0 210 1 210 2 210 3 210 4 210 5 210 6 210 7 210 8 210 9 210 10 210 11 210 12 210 13 210 14 210 15 210 16 210 17 210 18 210 19 210 20 210 21 210 22 210 23 210 24 210 25 210 26 210 27 210 28 210 0 210 29 210 30 210 30 210 30 210 30 210 31 210 32 210 33]
	[local76 9] = ['look>' 'bang>' 'open>' 'close>' 'lay,lay>' 'go>' 'sleep>' 'get>' 'break>']
	[local85 38] = ['<in/drawer' '[<up][/ceiling]' '/door' '[<down][/dirt]' '<below/carpet' '/carpet' '/wall' '/painting' '/wallpaper' '<(out,through)/window' '/window' '<behind/curtain' '/curtain' '<behind/blind' '/blind' '/furniture' '/lamp,ignite' '/chair' '<below/nightstand' '[<at,on]/nightstand' '<below/couch' '/couch' '<below/bed' '/luggage' '/bed' '/vase,knickknack' '[/*,!*][/*,!*]' '/window' '/curtain' '/drawer' '/*,!*[/*,!*]' '[<on,in,down][/bed[<down,on]]' '[<on,in,to]/bed' '[/*,!*][/*,!*]' '[<on,in,to]/bed' '/lamp,ignite' '/book' '/window']
	[local123 18] = [0 26 26 1 27 3 30 1 31 1 32 1 33 1 34 3 37 1]
	local141
	local142
	local143
)

(instance insideReg of Rgn
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& gCorpseFlags $0040) (== [gCycleTimers 0] 2)) ; Lillian
			(= [gCycleTimers 0] 1)
			(Print 210 34) ; "A cry of pain and anger coming from the upper reaches of the old mansion rends the night air."
		)
		(if (and (== gAct 0) (IsFlag 39) (not (IsFlag 40)))
			(Print 210 35) ; "You feel better now that you're back in the house. It was SCARY out there!"
			(SetFlag 40)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(for ((= local141 0)) (< local141 9) ((++ local141))
				(if (Said [local76 local141])
					(= temp0
						(+
							[local123 (= local143 (* local141 2))]
							[local123 (+ local143 1)]
						)
					)
					(for
						((= local142 [local123 local143]))
						(< local142 temp0)
						((++ local142))
						
						(if (Said [local85 local142])
							(if
								(and
									(== gCurRoomNum 74)
									(< (gEgo x:) 65)
									(!= local142 1)
									(!= local142 2)
									(!= local142 3)
									(!= local142 6)
									(!= local142 16)
									(!= local142 26)
									(!= local142 30)
								)
								(event claimed: 0)
							else
								(*= local142 2)
								(Print
									[local0 local142]
									[local0 (++ local142)]
								)
								(break)
							)
						)
					)
				)
			)
		)
	)
)

