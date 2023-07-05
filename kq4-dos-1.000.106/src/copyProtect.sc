;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Menu)

(public
	copyProtect 0
)

(local
	local0
	local1
	local2
	[local3 30]
	local33
	local34
	local35
)

(instance copyProtect of Rm
	(properties
		picture 991
	)

	(method (init)
		(super init:)
		(switch (= local0 (Random 1 79))
			(1
				(= local2 431)
			)
			(2
				(= local2 521)
			)
			(3
				(= local2 535)
			)
			(4
				(= local2 323)
			)
			(5
				(= local2 621)
			)
			(6
				(= local2 480)
			)
			(7
				(= local2 303)
			)
			(8
				(= local2 671)
			)
			(9
				(= local2 393)
			)
			(10
				(= local2 380)
			)
			(11
				(= local2 470)
			)
			(12
				(= local2 287)
			)
			(13
				(= local2 352)
			)
			(14
				(= local2 316)
			)
			(15
				(= local2 317)
			)
			(16
				(= local2 355)
			)
			(17
				(= local2 616)
			)
			(18
				(= local2 475)
			)
			(19
				(= local2 383)
			)
			(20
				(= local2 425)
			)
			(21
				(= local2 516)
			)
			(22
				(= local2 673)
			)
			(23
				(= local2 550)
			)
			(24
				(= local2 666)
			)
			(25
				(= local2 465)
			)
			(26
				(= local2 617)
			)
			(27
				(= local2 628)
			)
			(28
				(= local2 395)
			)
			(29
				(= local2 505)
			)
			(30
				(= local2 492)
			)
			(31
				(= local2 478)
			)
			(32
				(= local2 455)
			)
			(33
				(= local2 455)
			)
			(34
				(= local2 599)
			)
			(35
				(= local2 431)
			)
			(36
				(= local2 565)
			)
			(37
				(= local2 455)
			)
			(38
				(= local2 467)
			)
			(39
				(= local2 691)
			)
			(40
				(= local2 535)
			)
			(41
				(= local2 432)
			)
			(42
				(= local2 621)
			)
			(43
				(= local2 372)
			)
			(44
				(= local2 536)
			)
			(45
				(= local2 395)
			)
			(46
				(= local2 496)
			)
			(47
				(= local2 372)
			)
			(48
				(= local2 389)
			)
			(49
				(= local2 374)
			)
			(50
				(= local2 523)
			)
			(51
				(= local2 286)
			)
			(52
				(= local2 454)
			)
			(53
				(= local2 273)
			)
			(54
				(= local2 579)
			)
			(55
				(= local2 282)
			)
			(56
				(= local2 354)
			)
			(57
				(= local2 602)
			)
			(58
				(= local2 463)
			)
			(59
				(= local2 653)
			)
			(60
				(= local2 691)
			)
			(61
				(= local2 309)
			)
			(62
				(= local2 519)
			)
			(63
				(= local2 380)
			)
			(64
				(= local2 446)
			)
			(65
				(= local2 302)
			)
			(66
				(= local2 599)
			)
			(67
				(= local2 357)
			)
			(68
				(= local2 399)
			)
			(69
				(= local2 381)
			)
			(70
				(= local2 771)
			)
			(71
				(= local2 378)
			)
			(72
				(= local2 378)
			)
			(73
				(= local2 434)
			)
			(74
				(= local2 614)
			)
			(75
				(= local2 395)
			)
			(76
				(= local2 381)
			)
			(77
				(= local2 456)
			)
			(78
				(= local2 384)
			)
			(79
				(= local2 686)
			)
		)
		(switch local0
			(1
				(= local1
					{On page 2, what is the fourth word of the first sentence?}
				)
			)
			(2
				(= local1
					{On page 2, what is the fourth word of the second paragraph?}
				)
			)
			(3
				(= local1
					{On page 3, what is the fourth word in the first paragraph?}
				)
			)
			(4
				(= local1
					{On page 3, what is the sixth word in the first paragraph?}
				)
			)
			(5
				(= local1
					{On page 3, what is the fourth word in the third paragraph?}
				)
			)
			(6
				(= local1
					{On page 3, what is the third word in the second paragraph?}
				)
			)
			(7
				(= local1
					{On page 8, what is the first word of the first paragraph?}
				)
			)
			(8
				(= local1
					{On page 3, what is the seventh word in the third paragraph?}
				)
			)
			(9
				(= local1
					{On page 3, what is the last word of the third paragraph?}
				)
			)
			(10
				(= local1
					{On page 4, what is the third word in the first paragraph?}
				)
			)
			(11
				(= local1
					{On page 4, what is the last word in the third paragraph?}
				)
			)
			(12
				(= local1
					{On page 4, what is the sixth word of the first paragraph?}
				)
			)
			(13
				(= local1
					{On page 3, what is the eighth word in the third paragraph?}
				)
			)
			(14
				(= local1
					{On page 4, what is the seventh word in the first paragraph?}
				)
			)
			(15
				(= local1
					{On page 4, what is the third word in the third paragraph?}
				)
			)
			(16
				(= local1
					{On page 4, what is the eighth word in the third paragraph?}
				)
			)
			(17
				(= local1
					{On page 5, what is the fifth word in the second paragraph?}
				)
			)
			(18
				(= local1
					{On page 5, what is the second word in the third paragraph?}
				)
			)
			(19
				(= local1
					{On page 5, what is the fourth word in the first paragraph?}
				)
			)
			(20
				(= local1
					{On page 5, what is the ninth word in the fifth paragraph?}
				)
			)
			(21
				(= local1
					{On page 6, what is the third word in the first paragraph?}
				)
			)
			(22
				(= local1
					{On page 6, what is the fifth word in the first paragraph?}
				)
			)
			(23
				(= local1
					{On page 6, what is the sixth word in the second paragraph?}
				)
			)
			(24
				(= local1
					{On page 7, what is the first word in the first paragraph?}
				)
			)
			(25
				(= local1
					{On page 7, what is the tenth word in the first paragraph?}
				)
			)
			(26
				(= local1
					{On page 7, what is the third word in the second paragraph?}
				)
			)
			(27
				(= local1
					{On page 7, what is the fifth word in the second paragraph?}
				)
			)
			(28
				(= local1
					{On page 7, what is the second word in the third paragraph?}
				)
			)
			(29
				(= local1
					{On page 8, what is the fifth word in the first paragraph?}
				)
			)
			(30
				(= local1
					{On page 8, what is the last word of the first sentence in the first paragraph?}
				)
			)
			(31
				(= local1
					{On page 6, what is the last word in the second paragraph?}
				)
			)
			(32
				(= local1
					{On page 8, what is the second word in the third paragraph?}
				)
			)
			(33
				(= local1
					{On page 8, what is the sixth word in the third paragraph?}
				)
			)
			(34
				(= local1
					{On page 8, what is the ninth word in the third paragraph?}
				)
			)
			(35
				(= local1
					{On page 9, what is the third word in the first paragraph?}
				)
			)
			(36
				(= local1
					{On page 9, what is the fourth word in the first paragraph?}
				)
			)
			(37
				(= local1
					{On page 9, what is the seventh word in the first paragraph?}
				)
			)
			(38
				(= local1
					{On page 6, what is the fourth word in the second paragraph?}
				)
			)
			(39
				(= local1
					{On page 6, what is the eighth word in the second paragraph?}
				)
			)
			(40
				(= local1
					{On page 9, what is the seventh word in the second paragraph?}
				)
			)
			(41
				(= local1
					{On page 5, what is the seventh word in the fifth paragraph?}
				)
			)
			(42
				(= local1
					{On page 2, what is the sixth word in the second paragraph?}
				)
			)
			(43
				(= local1
					{On page 2, what is the eighth word in the second paragraph?}
				)
			)
			(44
				(= local1
					{On page 3, what is the tenth word in the first paragraph?}
				)
			)
			(45
				(= local1
					{On page 4, what is the second word in the second paragraph?}
				)
			)
			(46
				(= local1
					{On page 4, what is the fourth word in the third paragraph?}
				)
			)
			(47
				(= local1
					{On page 5, what is the third word in the second paragraph?}
				)
			)
			(48
				(= local1
					{On page 5, what is the eighth word in the third paragraph?}
				)
			)
			(49
				(= local1
					{On page 5, what is the eighth word in the fourth paragraph?}
				)
			)
			(50
				(= local1
					{On page 6, what is the ninth word in the first paragraph?}
				)
			)
			(51
				(= local1
					{On page 7, what is the ninth word of the third paragraph?}
				)
			)
			(52
				(= local1
					{What is the second word of the first paragraph in the OVERVIEW?}
				)
			)
			(53
				(= local1
					{What is the first word of the second paragraph in the OVERVIEW?}
				)
			)
			(54
				(= local1
					{What is the third word of the second paragraph in the OVERVIEW?}
				)
			)
			(55
				(= local1
					{What is the sixth word of the first paragraph in the OVERVIEW?}
				)
			)
			(56
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the first word of tip #1 (HOW TO MOVE AROUND)?}
				)
			)
			(57
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the sixth word of tip #1 (HOW TO MOVE AROUND)?}
				)
			)
			(58
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the fifth word in the first paragraph of tip #2 (STAY OUT OF DANGER)}
				)
			)
			(59
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the eighth word in the second paragraph of tip #2 (STAY OUT OF DANGER)}
				)
			)
			(60
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the fourth word in the second paragraph of tip #2 (STAY OUT OF DANGER)}
				)
			)
			(61
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the first word of tip #3 (BE OBSERVANT)?}
				)
			)
			(62
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the fourth word of tip #3 (BE OBSERVANT)?}
				)
			)
			(63
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the last word of tip #3 (BE OBSERVANT)?}
				)
			)
			(64
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the last word of tip #1 (HOW TO MOVE AROUND)?}
				)
			)
			(65
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the first word of tip #4 (MAP YOUR PROGRESS)?}
				)
			)
			(66
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the fifth word of tip #4 (MAP YOUR PROGRESS)?}
				)
			)
			(67
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the seventh word of tip #4 (MAP YOUR PROGRESS)?}
				)
			)
			(68
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the ninth word of tip #4 (MAP YOUR PROGRESS)?}
				)
			)
			(69
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the fourth word of tip #5 (BRING ALONG SOME HELP)?}
				)
			)
			(70
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the seventh word of tip #5 (BRING ALONG SOME HELP)?}
				)
			)
			(71
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the ninth word of tip #5 (BRING ALONG SOME HELP)?}
				)
			)
			(72
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the last word of tip #5 (BRING ALONG SOME HELP)?}
				)
			)
			(73
				(= local1
					{What is the last word starting with "b" in the verb list?}
				)
			)
			(74
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the last word of tip #7 (LEAVE NO STONE UNTURNED)?}
				)
			)
			(75
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the fourth word in the first paragraph of tip #8 (AT THE END OF YOUR ROPE)?}
				)
			)
			(76
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the sixth word in the first paragraph of tip #8 (AT THE END OF YOUR ROPE)?}
				)
			)
			(77
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the third word in the second paragraph of tip #8 (AT THE END OF YOUR ROPE)?}
				)
			)
			(78
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the last word in the first paragraph of tip #8 (AT THE END OF YOUR ROPE)?}
				)
			)
			(79
				(= local1
					{In the section TIPS FOR NEW ADVENTURE PLAYERS, what is the eighth word in the first paragraph of tip #2 (STAY OUT OF DANGER)?}
				)
			)
		)
	)

	(method (doit)
		(= local3 0)
		(= local35 0)
		(HandsOn)
		(= global205 0)
		(Print
			(Format @global300 701 0 local1) ; "In order to verify your legal ownership, please use your "King's Quest IV" manual to answer the following question: %s"
			#at
			7
			15
			#font
			gSmallFont
			#width
			290
			#edit
			@local3
			30
		)
		(if (and global215 (= local33 (ReadNumber @local3)))
			(TheMenuBar draw:)
			(SL enable:)
			(self newRoom: local33)
			(return)
		)
		(for ((= local33 0)) (< local33 (StrLen @local3)) ((++ local33))
			(= local34 (& (= local34 (StrAt @local3 local33)) $005f))
			(StrAt @local3 local33 local34)
			(+= local35 local34)
		)
		(cond
			((not (StrCmp @local3 {BOBALU}))
				(gCurRoom newRoom: 700)
			)
			((== local35 local2)
				(gCurRoom newRoom: 700)
			)
			(else
				(Print 701 1) ; "Sorry, what you just typed does not match the "King's Quest IV" manual. You must have the manual to play this game. If you do not, contact Sierra's Customer Support Department. The telephone number is on your original disk label."
				(= gQuit 1)
			)
		)
	)
)

