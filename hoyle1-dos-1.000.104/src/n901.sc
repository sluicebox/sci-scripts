;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 901)
(include sci.sh)
(use Main)
(use Interface)

(public
	proc901_0 0
)

(procedure (proc901_0 &tmp [temp0 40] temp40)
	(if (not (Print {Save setup file?} #button {Save} 1 #button {Cancel} 0))
		(return)
	)
	(SetCursor 997 1)
	(Load rsVIEW 991)
	(if (== (= temp40 (FOpen {HOYLE.SET} 2)) -1)
		(Print
			{Can't save setup file to disk\n__- Write-protected or\n__- Bad disk.}
		)
	else
		(Format ; "%2d%2d%2d%2d%2d%2d%2d%2d%2d%2d%3d"
			@temp0
			901
			0
			global405
			global406
			global407
			global433
			gSpeed
			global236
			(DoSound sndSET_SOUND)
			global445
			global507
			global774
			global511
		)
		(FPuts temp40 @temp0)
		(FClose temp40)
	)
	(cond
		((or (== gCurRoomNum 3) (== gCurRoomNum 4) (== gCurRoomNum 5))
			(Load rsVIEW 992)
		)
		((or (== gCurRoomNum 1) (== gCurRoomNum 2) (== gCurRoomNum 6))
			(Load rsVIEW 993)
		)
	)
	(UnLoad 128 991)
	(UnLoad 128 992)
	(UnLoad 128 993)
	(SetCursor 999 1)
)

