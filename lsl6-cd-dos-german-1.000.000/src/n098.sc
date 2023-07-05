;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use n079)
(use Print)

(public
	proc98_0 0
)

(procedure (proc98_0 &tmp temp0)
	(if (!= gCurRoomNum 140)
		(SetPort 0)
		(SetPort 0 0 190 320 10 0)
	)
	(gSounds eachElementDo: #pause)
	(= temp0 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(switch
		(Print
			font: gUserFont
			posn: 11 157
			addButton:
				100
				(switch (gGame printLang:)
					(49 {Spiel Laden})
					(33 {Ouvrir Jeu})
					(else {Open Game})
				)
				0
				0
			addButton:
				-1
				(switch (gGame printLang:)
					(49 {Weitermachen})
					(33 {Continuer})
					(else {Continue})
				)
				(proc79_4 85 85 71 85 85)
				0
			addButton:
				110
				(switch (gGame printLang:)
					(49 {Einleitung})
					(33 {Intro})
					(else {Intro})
				)
				(proc79_4 187 157 142 157 157)
				0
			addButton:
				200
				(switch (gGame printLang:)
					(49 {Kredit})
					(33 {G\82n\82rique})
					(else {Credits})
				)
				(proc79_4 0 197 182 197 197)
				(proc79_4 14 0 0 0 0)
			addButton:
				300
				(switch (gGame printLang:)
					(49 {Spielen})
					(33 {Jouer})
					(else {Play})
				)
				(proc79_4 203 253 253 253 253)
				(proc79_4 14 0 0 0 0)
			init:
		)
		(100
			(gGame restore:)
		)
		(110
			(gCurRoom newRoom: 130)
		)
		(200
			(gCurRoom newRoom: 120)
		)
		(300
			(gCurRoom newRoom: 200)
		)
	)
	(gGame setCursor: temp0)
	(gSounds eachElementDo: #pause 0)
	(if (!= gCurRoomNum 140)
		(SetPort 0 0 139 320 10 0)
	)
	(DisposeScript 98)
)

