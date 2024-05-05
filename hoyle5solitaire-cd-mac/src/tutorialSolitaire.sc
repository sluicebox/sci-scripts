;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6101)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	tutorialSolitaire 0
)

(instance tutorialSolitaire of Code
	(properties)

	(method (init param1 param2)
		(switch gCardGameScriptNumber
			(6001
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns only the top card is playable.\nCards in Columns can only be played to Foundations.}
								6
								6
							init:
						)
					)
					(2
						(if (not param2)
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addTextF: {\n__This Foundation is full.}
								init:
							)
						else
							(if (== param2 1)
								(Print
									ticks: 400
									fore: 0
									mode: 0
									addBitmap: 917 4 0
									font: gUserFont
									addTextF:
										{\n__You can't play cards from the\n__Foundations. The next playable card\n__here should be an Ace.}
									init:
								)
							)
							(if (== param2 8)
								(Print
									ticks: 400
									fore: 0
									mode: 0
									addBitmap: 917 4 0
									font: gUserFont
									addTextF:
										{\n__You can't play cards from the\n__Foundations. The next playable card\n__here should be an 8.}
									init:
								)
							)
							(if (== param2 11)
								(Print
									ticks: 400
									fore: 0
									mode: 0
									addBitmap: 917 4 0
									font: gUserFont
									addTextF:
										{\n__You can't play cards from the\n__Foundations. The next playable card\n__here should be a Jack.}
									init:
								)
							)
							(if (== param2 12)
								(Print
									ticks: 400
									fore: 0
									mode: 0
									addBitmap: 917 4 0
									font: gUserFont
									addTextF:
										{\n__You can't play cards from the\n__Foundations. The next playable card\n__here should be a Queen.}
									init:
								)
							)
							(if (== param2 13)
								(Print
									ticks: 400
									fore: 0
									mode: 0
									addBitmap: 917 4 0
									font: gUserFont
									addTextF:
										{\n__You can't play cards from the\n__Foundations. The next playable card\n__here should be a King.}
									init:
								)
							)
							(if (and (< param2 11) (!= param2 1) (!= param2 8))
								(Print
									ticks: 400
									fore: 0
									mode: 0
									addBitmap: 917 4 0
									font: gUserFont
									addTextF:
										{\n__You can't play cards from the\n__foundations. The next playable card\n__here should be a %d.}
										param2
									init:
								)
							)
						)
					)
				)
			)
			(6002
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is\nplayable. Cards in Columns can only\nbe played to Foundations, but not\nuntil all Stock cards have been placed\nin the Columns.}
								6
								6
							init:
						)
					)
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
								6
								6
							init:
						)
					)
					(4
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{Cards in Columns can only be played to\nFoundations, but not until all Stock cards\nhave been placed in the Columns.}
								6
								6
							init:
						)
					)
					(5
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
								6
								6
							init:
						)
					)
				)
			)
			(6003
				(switch param1
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup and in suit from the rank of\nthe first card played to a Foundation.}
								6
								6
							init:
						)
					)
					(3
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{Not a complete set of Packed Cards.\nIn Columns, only the top card or an\nentire set of Packed Cards can be moved.}
								6
								6
							init:
						)
					)
				)
			)
			(6004
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is\nplayable. Columns are built down\nregardless of suit. Empty Columns can\nbe filled with Kings.}
								6
								6
							init:
						)
					)
					(2
						(if (== global927 0)
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundations. Foundations are built\nup from Ace to King regardless of suit.}
									6
									6
								init:
							)
						else
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
									6
									6
								init:
							)
						)
					)
				)
			)
			(6005
				(switch param1
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
								6
								6
							init:
						)
					)
				)
			)
			(6006
				(switch param1
					(3
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card or an\nentire set of Packed Cards can be moved.}
								6
								6
							init:
						)
					)
					(4
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundation. Foundations are built\nup, in suit, from the rank of the\nfirst card played to a Foundation.}
								6
								6
							init:
						)
					)
				)
			)
			(6007
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is\nplayable. Cards in Columns can only be\nplayed to the Foundation.}
								6
								6
							init:
						)
					)
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. The Foundation is built\nup or down regardless of suit.}
								6
								6
							init:
						)
					)
					(4
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. The Foundation is built\nup or down regardless of suit.}
								6
								6
							init:
						)
					)
				)
			)
			(6008
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is\nplayable. Columns are built down\nregardless of suit. Empty Columns\ncan be filled with any available card.}
								6
								6
							init:
						)
					)
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
								6
								6
							init:
						)
					)
				)
			)
			(6009)
			(6010
				(switch param1
					(3
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card or an\nentire set of Packed Cards can\nbe moved.}
								6
								6
							init:
						)
					)
				)
			)
			(6011
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is playable.\nColumns are built down and in suit.}
								6
								6
							init:
						)
					)
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
								6
								6
							init:
						)
					)
				)
			)
			(6012
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is\nplayable. Columns are built up or down\nregardless of suit. Empty Columns\nin an Easy game can be filled\nwith any available card, in a\nDifficult game only with Kings.}
								6
								6
							init:
						)
					)
					(2
						(if (== global927 0)
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundations. Foundations are built\nup and in suit from the rank of\nthe first card played to a Foundation.}
									6
									6
								init:
							)
						else
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundations. Foundations are built\nup and in suit from Ace to King.}
									6
									6
								init:
							)
						)
					)
				)
			)
			(6013
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is playable.\nColumns are built down regardless of\nsuit.}
								6
								6
							init:
						)
					)
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
								6
								6
							init:
						)
					)
				)
			)
			(6014
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is\nplayable. Columns are built down\nregardless of suit. In a Difficult\ngame empty Columns can be filled\nwith Kings.}
								6
								6
							init:
						)
					)
					(2
						(if (== global927 0)
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundations. Foundations are built\nup from Ace to King regardless of suit.}
									6
									6
								init:
							)
						else
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
									6
									6
								init:
							)
						)
					)
				)
			)
			(6015
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is\nplayable. Columns are built down and\nin suit. Empty columns in an Easy game\ncan be filled with any available\ncard, in a Difficult game only with\nKings.}
								6
								6
							init:
						)
					)
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup and in suit, from Ace to King.}
								6
								6
							init:
						)
					)
				)
			)
			(6016
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is playable.\nColumns are built up or down regardless\nof suit.}
								6
								6
							init:
						)
					)
					(2
						(if (== global927 0)
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundations. Foundations are built\nup and in suit from the rank of\nthe first card played to a Foundation.}
									6
									6
								init:
							)
						else
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundations. Foundations are built\nup and in suit from Ace to King.}
									6
									6
								init:
							)
						)
					)
				)
			)
			(6017
				(switch param1
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup, in suit, from Ace to King.}
								6
								6
							init:
						)
					)
				)
			)
			(6018
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is playable.\nCards in Columns can only be played to\nthe Foundations.}
								6
								6
							init:
						)
					)
					(2
						(if (== global927 0)
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from here.\nThe Foundations are built up or down\nin any suit.}
									6
									6
								init:
							)
						else
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from here.\nThe Foundations are built up or down\nin any suit by alternating color.}
									6
									6
								init:
							)
						)
					)
				)
			)
			(6019)
			(6020
				(if (or (== param1 2) (== param1 4))
					(Print
						ticks: 400
						fore: 0
						mode: 0
						addBitmap: 917 4 0
						font: gUserFont
						addText:
							{Once you play a card in this\nspace it cannot be moved.}
							6
							6
						init:
					)
				)
			)
			(6021)
			(6022
				(switch param1
					(1
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{In Columns, only the top card is playable.}
								6
								6
							init:
						)
					)
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Only cards from the\nColumns can be played to this\nFoundation.}
								6
								6
							init:
						)
					)
				)
			)
			(6023)
			(6024
				(switch param1
					(2
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundations. Foundations are built\nup and in suit from the rank of\nthe first card played to a Foundation.}
								6
								6
							init:
						)
					)
					(3
						(if (== global927 0)
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{In Columns, only the top card or an\nentire set of Packed Cards can be\nmoved. Columns are built down and in\nsuit wrapping from Ace to King, as\nnecessary. Empty spaces can be filled\nwith any available card.}
									8
									6
								init:
							)
						else
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{In Columns, only the top card or an\nentire set of Packed Cards can be\nmoved. Empty spaces can be filled\nonly with a card of one rank lower\nthan the Foundations' starting rank.}
									6
									6
								init:
							)
						)
					)
				)
			)
			(6025
				(switch param1
					(4
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundation.}
								6
								6
							init:
						)
					)
				)
			)
			(6026
				(switch param1
					(4
						(Print
							ticks: 400
							fore: 0
							mode: 0
							addBitmap: 917 4 0
							font: gUserFont
							addText:
								{You can't play cards from the\nFoundation.}
								6
								6
							init:
						)
					)
				)
			)
			(6027
				(if (or (== param1 2) (== param1 4))
					(Print
						ticks: 400
						fore: 0
						mode: 0
						addBitmap: 917 4 0
						font: gUserFont
						addText:
							{Once a card has been played here\nit cannot be moved.}
							6
							6
						init:
					)
				)
			)
			(6028
				(if (or (== param1 2) (== param1 4))
					(Print
						ticks: 400
						fore: 0
						mode: 0
						addBitmap: 917 4 0
						font: gUserFont
						addText:
							{Once a card has been played here\nit cannot be moved.}
							6
							6
						init:
					)
				)
			)
		)
		(DisposeScript 6101)
	)
)

