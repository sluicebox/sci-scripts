;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Game)

(public
	phonoReg 0
)

(instance phonoReg of Rgn
	(properties)

	(method (init)
		(= keep 1)
	)

	(method (newRoom newRoomNumber)
		(switch gCurRoomNum
			(2200
				(switch newRoomNumber
					(3200
						(global114 setVol: (= global184 63) 1)
					)
					(28815
						(global114 endPause:)
						(= global184 0)
					)
				)
			)
			(3200
				(switch newRoomNumber
					(2200
						(global114 setVol: (= global184 31) 1)
					)
					(3400
						(global114 setVol: (= global184 31) 1)
					)
				)
			)
			(3400
				(switch newRoomNumber
					(3200
						(global114 setVol: (= global184 63) 1)
					)
				)
			)
			(3760
				(switch newRoomNumber
					(3400
						(global114 setVol: (= global184 31) 1)
					)
				)
			)
			(4200
				(switch newRoomNumber
					(28100
						(global114 endPause:)
						(= global184 0)
					)
					(13100
						(global114 setVol: (= global184 95) 1)
					)
				)
			)
			(10200
				(switch newRoomNumber
					(13100
						(global114 setVol: (= global184 95) 1)
					)
				)
			)
			(12100
				(switch newRoomNumber
					(13100
						(global114 setVol: (= global184 95) 1)
					)
				)
			)
			(13100
				(switch newRoomNumber
					(4200
						(global114 setVol: (= global184 63) 1)
					)
					(10000
						(global114 setVol: (= global184 63) 1)
					)
					(12100
						(global114 setVol: (= global184 63) 1)
					)
				)
			)
			(13400
				(switch newRoomNumber
					(9100
						(global114 setVol: (= global184 127) 1)
					)
				)
			)
			(13500
				(switch newRoomNumber
					(9100
						(global114 setVol: (= global184 127) 1)
					)
					(15100
						(global114 setVol: (= global184 63) 1)
					)
				)
			)
			(15100
				(switch newRoomNumber
					(13500
						(global114 setVol: (= global184 95) 1)
					)
					(14100
						(global114 setVol: (= global184 31) 1)
					)
					(14200
						(if (IsFlag 120)
							(global114 pause:)
						else
							(global114 setVol: (= global184 31) 1)
						)
					)
				)
			)
			(14100
				(switch newRoomNumber
					(15100
						(global114 setVol: (= global184 63) 1)
					)
				)
			)
			(15200
				(switch newRoomNumber
					(18100
						(global114 setVol: (= global184 31) 1)
					)
					(14200
						(if (IsFlag 120)
							(global114 pause:)
						else
							(global114 setVol: (= global184 31) 1)
						)
					)
				)
			)
			(18100
				(switch newRoomNumber
					(15200
						(global114 setVol: (= global184 63) 1)
					)
				)
			)
			(15300
				(switch newRoomNumber
					(16200
						(global114 setVol: (= global184 31) 1)
					)
					(17000
						(global114 setVol: (= global184 31) 1)
					)
					(17100
						(global114 setVol: (= global184 31) 1)
					)
				)
			)
			(16200
				(switch newRoomNumber
					(15300
						(global114 setVol: (= global184 63) 1)
					)
				)
			)
			(17000
				(switch newRoomNumber
					(15300
						(global114 setVol: (= global184 63) 1)
					)
				)
			)
			(17100
				(switch newRoomNumber
					(15300
						(global114 setVol: (= global184 63) 1)
					)
				)
			)
		)
	)
)

