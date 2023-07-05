;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	aboutCode 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(Print mode: 1 ticks: (* gTextSpeed 10) addText: 2 0 0 param1 0 0 13)
	(= temp0 (Print dialog:))
	(Print
		addIcon:
			910
			param2
			0
			(-
				(/ (+ (temp0 nsLeft:) (temp0 nsRight:)) 2)
				(+ (/ (CelWide 910 param2) 2) 5)
			)
			(cond
				((OneOf param2 2 3) 60)
				((== param2 5) 35)
				(else 30)
			)
		init:
	)
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 300])
		(Load rsVIEW 910)
		(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
		(gGame setCursor: 998)
		(= global134 20)
		(gSystemWindow color: 0 back: 20)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 1 0 0 13 ; "FREDDY PHARKAS, FRONTIER PHARMACIST is brought to you in living VGA by the hombres out at Sierra On-Line, Inc. and Screw Loose Amusements."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 2 40 0 13 ; "Designed and written by Al Lowe and Josh Mandel"
					addIcon: 910 0 0 0 30
					addIcon: 910 1 0 105 30
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 3 1))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 4 2))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 5 3))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 6 4))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 7 5))
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 8 0 0 13 ; "Additional Animation and Mondo Thanks To: Jeff Crowe Joan Delehanty Maria Fruehe Gloria Garland Michael Hutchison Tony Margioni Jerry Moore Cindy Walker Chris "Smokehouse" Willis Deanna Yhalkee"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 9 0 0 13 ; "Special Guest Programming: Doug Oldfield Carlos Escobar Brian K. Hughes  Customer Service Liaisons: Larry Buchanan Mike Weiner"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 10 0 0 13 ; "Systems Programming: Vana Baker Ed Critchlow Dan Foy J. Mark Hood Brian K. Hughes Ken Koch Jack Magne Terry McHenry Martin Peters Larry Scott Christopher Smith Mark Wilden"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 11 0 0 13 ; "Special Thanks To: Bob Ballew Donovan Holmes Jeff & Jon Martin Rick Spurgeon Nathan Gams Alan Mandel And the Freddy Pharkas Beta Testers"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 12 0 0 13 ; "If you're not enjoying FREDDY PHARKAS, FRONTIER PHARMACIST, you will no doubt also dislike Al Lowe's other groundbreaking comedy adventure games:"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 13 0 0 13 ; "|c1|Leisure Suit Larry in the Land of the Lounge Lizards;|c||c2| Leisure Suit Larry 2: Leisure Suit Larry Goes Looking For Love (In Several Wrong Places);|c||c3| Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals;|c| and |c0|Leisure Suit Larry 5: Passionate Patti Does a Little Undercover Work.|c|"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 14 0 0 13 ; "To order these or any other Sierra products (including the handy six-pack of FREDDY PHARKAS, FRONTIER PHARMACIST), call |c2|1-800-326-6654|c|, 7:00 am to 7:00 pm, Monday through Friday; or fax us your order at |c0|209-683-4297|c|. For International orders, call |c3|(44) 734303201|c|."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 15 0 0 13 ; "Hints for Freddy Pharkas are available on our 24-hour Hint Line, |c1|900-370-5583|c| (United States) or |c1|(44) 734304004|c| (United Kingdom). $0.75 each minute; long distance charges are included in the fee. |c0|Callers under the age of 18 must get their parents' permission before calling.|c|"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 16 0 0 13 ; "Hint Books may be purchased from our Sales Department. Hints or answers are also available for free by mail (P.O. Box 200, Coarsegold, CA, 93614-0200, Attn: Hint Department), or can be found on the Sierra Bulletin Board, (|c2|209-683-4463|c|)."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(self dispose:)
	)

	(method (dispose)
		(Print ticks: -1)
		(= global134 34)
		(gSystemWindow color: 0 back: 34)
		(gGame setCursor: gNormalCursor)
		(DisposeScript 13)
	)
)

