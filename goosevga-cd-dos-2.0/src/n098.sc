;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use n096)
(use User)
(use Menu)
(use Actor)

(public
	proc98_0 0
	proc98_1 1
)

(procedure (proc98_0 &tmp temp0 temp1 temp2)
	(= global104 0)
	(DoAudio audLANGUAGE (= global169 (DoAudio audLANGUAGE -1)))
	(gGame setSpeed: 3)
	(= global60 40)
	(= global61 155)
	(= global62 258)
	(= global63 0)
	(= global138 272)
	(= global139 182)
	(= global137 -14)
	(= global141 251)
	(= global142 154)
	(= global140 7)
	(= global100 1)
	(DoAudio audRATE 11000)
	(= global106 (Graph grGET_COLOURS))
	(User blocks: 0 canControl: 0 x: -1 y: 150 init: (User inputLineAddr:) 30)
	(gEgo looper: MyLooper)
	(User alterEgo: gEgo)
	((User alterEgo:) moveSpeed: 1)
	(HandsOn)
	(= gPossibleScore 18)
	(= gUserFont 4)
	(= global130 0)
	(= [global200 34] 57)
	(for ((= temp1 41)) (<= temp1 60) ((++ temp1))
		(if (and (!= temp1 57) (!= temp1 53) (!= temp1 43))
			(proc96_1 temp1)
		)
	)
	(= [global200 24] 0)
	(= [global200 26] 0)
	(= gScore 0)
	(= global147 -22)
	(= global148 161)
	(for ((= global149 0)) (< global149 6) ((++ global149))
		(= [global261 global149] (+= global147 15))
		(= [global280 global149] global148)
	)
	(= global147 -16)
	(= global148 170)
	(for ((= global149 6)) (< global149 12) ((++ global149))
		(= [global261 global149] (+= global147 15))
		(= [global280 global149] global148)
	)
	(= global147 -22)
	(= global148 179)
	(for ((= global149 12)) (< global149 18) ((++ global149))
		(= [global261 global149] (+= global147 15))
		(= [global280 global149] global148)
	)
	(DoSound sndSET_SOUND 1)
	(DoSound sndMASTER_VOLUME (= global125 12))
	(gLongSong loop: -1 vol: 127 priority: 0)
	(if (GameIsRestarting)
		(MemorySegment 1 @global190) ; MS_RESTORE_TO
		(= global170 (StrAt @global190 0))
		(= global157 (- (StrAt @global190 1) 32))
		(StrAt gCurSaveDir 0 (- (StrAt @global190 2) 1))
		(= gSaveSlot (- (StrAt @global190 3) 32))
		(= global114 (- (StrAt @global190 5) 32))
	)
)

(procedure (proc98_1 &tmp [temp0 270])
	(Palette palSET_INTENSITY 0 255 0)
	(SetPort 0 0 200 320 0 0)
	(= global57 -1)
	(DrawPic 800 0)
	(Graph grFILL_BOX 3 4 159 262 1 0 0 0)
	(Graph grUPDATE_BOX 0 0 200 320 1)
	(SetPort 0 0 156 258 3 4)
	(StrCpy @global180 (+ @global190 3))
	(clr)
	(TheMenuBar state: 1)
	(= global104 0)
	(gGame setCursor: 999 (HaveMouse))
	(proc0_19 0 320 3)
	(= global176 0)
	(= gCurRoomNum 0)
	(gCurRoom newRoom: 32)
)

