;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 779)
(include sci.sh)
(use Main)
(use Plane)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm779 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 4]
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
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
)

(instance rm779 of Room
	(properties
		picture 920
	)

	(method (init)
		(gThePlane picture: (if (IsHiRes) 10920 else 920) setRect: 0 0 320 164 1)
		(credPlane init:)
		(UpdatePlane credPlane)
		(gTheIconBar disable:)
		(gTheCursor hide:)
		(gGlobalSound0 fade: 70 4 2 0)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(self setScript: closeOut)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gThePlane setRect: 0 0 319 199)
		(PalVary 3) ; PalVaryKill
		(credPlane dispose:)
		(gTheCursor show:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (not local0)
			(event claimed: 1)
			(return)
		else
			(gGlobalSound0 fade:)
			(gGame setScript: restartScr)
		)
	)
)

(instance closeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 1009 1010)
				(gGlobalSound1 number: 1009 loop: 1 play: self)
			)
			(1
				(Load rsSOUND 893)
				(gGlobalSound1 number: 1010 loop: 1 play: self)
				(= seconds 9)
			)
			(2
				(= seconds 0)
				(Purge 1000)
				(gGlobalSound0 number: 893 loop: -1 flags: 5 play:)
				(if (IsHiRes)
					(LoadMany
						rsVIEW
						1920
						1921
						1922
						1923
						1924
						1925
						1926
						1927
						1928
						1929
						1930
						1931
						1932
						1933
						1934
						1935
						1936
						1942
					)
					(gCurRoom setScript: hiResMacCredits)
				else
					(LoadMany rsVIEW 1940 1941)
					(gCurRoom setScript: loResCredits)
				)
			)
		)
	)
)

(instance loResCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: displayLoSingles self)
			)
			(1
				((= local1 (SpecActor new:))
					view: 1940
					setLoop: 6 1
					posn: 160 97
					init:
				)
				(= cycles 2)
			)
			(2
				(= ticks 180)
			)
			(3
				(local1 setMotion: MoveTo 160 0 local1)
				((= local2 (SpecActor new:))
					setLoop: 7 1
					y: (+ 165 (CelHigh 1940 7 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(4
				(local2 setMotion: MoveTo 160 0 local2)
				((= local3 (SpecActor new:))
					setLoop: 8 1
					y: (+ 165 (CelHigh 1940 8 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(5
				(local3 setMotion: MoveTo 160 0 local3)
				((= local11 (SpecActor new:))
					setLoop: 9 1
					y: (+ 165 (CelHigh 1940 9 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(6
				(local11 setMotion: MoveTo 160 0 local11)
				((= local5 (SpecActor new:))
					view: 1938
					loop: 0
					cel: 0
					y: (+ 165 (CelHigh 1938 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(7
				(local5 setMotion: MoveTo 160 0 local5)
				((= local6 (SpecActor new:))
					view: 1943
					y: (+ 215 (CelHigh 1943 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(8
				(local6 setMotion: MoveTo 160 0 local6)
				((= local12 (SpecActor new:))
					setLoop: 10 1
					y: (+ 165 (CelHigh 1940 10 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(9
				(local12 setMotion: MoveTo 160 0 local12)
				((= local13 (SpecActor new:))
					setLoop: 11 1
					y: (+ 165 (CelHigh 1940 11 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(10
				(local13 setMotion: MoveTo 160 0 local13)
				((= local14 (SpecActor new:))
					setLoop: 12 1
					y: (+ 165 (CelHigh 1940 12 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(11
				(local14 setMotion: MoveTo 160 0 local14)
				((= local15 (SpecActor new:))
					setLoop: 13 1
					y: (+ 165 (CelHigh 1940 13 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(12
				(local15 setMotion: MoveTo 160 0 local15)
				((= local16 (SpecActor new:))
					setLoop: 13 1
					setCel: 2
					y: (+ 165 (CelHigh 1940 13 2))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(13
				(local16 setMotion: MoveTo 160 0 local16)
				((= local17 (SpecActor new:))
					setLoop: 14 1
					y: (+ 165 (CelHigh 1940 14 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(14
				(local17 setMotion: MoveTo 160 0 local17)
				((= local18 (SpecActor new:))
					setLoop: 13 1
					cel: 1
					y: (+ 165 (CelHigh 1940 13 1))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(15
				(Load rsVIEW 1943)
				(local18 setMotion: MoveTo 160 0 local18)
				((= local19 (SpecActor new:))
					setLoop: 15 1
					y: (+ 165 (CelHigh 1940 15 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(16
				(local19 setMotion: MoveTo 160 0 local19)
				((= local20 (SpecActor new:))
					view: 1943
					setLoop: 0 1
					y: (+ 165 (CelHigh 1943 0 0))
					init:
					setMotion: MoveTo 160 158 self
				)
			)
			(17
				(local20 setMotion: MoveTo 160 0 local20)
				((= local21 (SpecActor new:))
					view: 1943
					setLoop: 1 1
					y: (+ 165 (CelHigh 1943 1 0))
					init:
					setMotion: MoveTo 160 158 self
				)
			)
			(18
				(local21 setMotion: MoveTo 160 0 local21)
				((= local22 (SpecActor new:))
					view: 1943
					setLoop: 2 1
					y: (+ 165 (CelHigh 1943 2 0))
					init:
					setMotion: MoveTo 160 45 self
				)
			)
			(19
				(local22 setMotion: MoveTo 160 0 local22)
				((= local25 (SpecActor new:))
					view: 1938
					setLoop: 0 1
					y: (+ 165 (CelHigh 1938 0 0))
					init:
					setMotion: MoveTo 160 145 self
				)
			)
			(20
				(local25 setMotion: MoveTo 160 -90 local25)
				((= local26 (SpecActor new:))
					view: 1938
					setLoop: 1 1
					y: (+ 196 (CelHigh 1938 1 0))
					init:
					setMotion: MoveTo 160 145 self
				)
			)
			(21
				(local26 setMotion: MoveTo 160 -90 local26)
				((= local27 (SpecActor new:))
					view: 1938
					setLoop: 2 1
					y: (+ 146 (CelHigh 1938 2 0))
					init:
					setMotion: MoveTo 160 145 self
				)
			)
			(22
				(local27 setMotion: MoveTo 160 -90 local27)
				((= local28 (SpecActor new:))
					view: 1938
					setLoop: 3 1
					y: (+ 170 (CelHigh 1938 3 0))
					init:
					setMotion: MoveTo 160 45 self
				)
			)
			(23
				(local28 setMotion: MoveTo 160 -90 local28)
				((= local33 (SpecActor new:))
					view: 1944
					setLoop: 3 1
					y: (+ 170 (CelHigh 1944 0 0))
					init:
					setMotion: MoveTo 160 45 self
				)
			)
			(24
				(local33 setMotion: MoveTo 160 -90 local33)
				((= local34 (SpecActor new:))
					view: 1944
					setLoop: 2 1
					y: (+ 165 (CelHigh 1944 1 0))
					init:
					setMotion: MoveTo 160 45 self
				)
			)
			(25
				(local34 setMotion: MoveTo 160 -90 local34)
				((= local35 (SpecActor new:))
					view: 1944
					setLoop: 1 1
					y: (+ 165 (CelHigh 1944 2 0))
					init:
					setMotion: MoveTo 160 45 self
				)
			)
			(26
				(local35 setMotion: MoveTo 160 -90 local35)
				((= local36 (SpecActor new:))
					view: 1944
					setLoop: 0 1
					y: (+ 165 (CelHigh 1944 3 0))
					init:
					setMotion: MoveTo 160 45 self
				)
			)
			(27
				(local36 setMotion: MoveTo 160 -90 local36)
				((= local37 (SpecActor new:))
					view: 1941
					setLoop: 0
					y: (+ 165 (CelHigh 1941 0 0))
					init:
					setMotion: MoveTo 160 145 self
				)
			)
			(28
				(gCurRoom drawPic: 0)
				(= ticks 60)
			)
			(29
				(= local0 1)
				(= ticks 180)
			)
			(30
				(gGlobalSound0 fade:)
				(gGame setScript: restartScr)
			)
		)
	)
)

(instance displayLoSingles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(= cycles 2)
			)
			(1
				(credView posn: 160 97 view: 1940 loop: register cel: 0 init:)
				(= cycles 2)
			)
			(2
				(= ticks 180)
			)
			(3
				(credView dispose:)
				(= cycles 1)
			)
			(4
				(= ticks 60)
			)
			(5
				(++ register)
				(if (< register 6)
					(self changeState: 1)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance hiResCredits of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: displayHiSingles self)
			)
			(1
				((= local1 (SpecActor new:)) view: 1925 posn: 160 97 init:)
				(= cycles 2)
			)
			(2
				(= ticks 180)
			)
			(3
				(local1 setMotion: MoveTo 160 0 local1)
				((= local2 (SpecActor new:))
					view: 1926
					y: (+ 165 (CelHigh 1926 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(4
				(local2 setMotion: MoveTo 160 0 local2)
				((= local3 (SpecActor new:))
					view: 1927
					y: (+ 165 (CelHigh 1927 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(5
				(local3 setMotion: MoveTo 160 0 local3)
				((= local5 (SpecActor new:))
					view: 1927
					loop: 2
					cel: 0
					y: (+ 165 (CelHigh 1927 2 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(6
				(local5 setMotion: MoveTo 160 0 local5)
				((= local11 (SpecActor new:))
					view: 1928
					y: (+ 165 (CelHigh 1928 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(7
				(local11 setMotion: MoveTo 160 0 local11)
				((= local12 (SpecActor new:))
					view: 1929
					loop: 0
					cel: 0
					y: (+ 165 (CelHigh 1929 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(8
				(local12 setMotion: MoveTo 160 0 local12)
				((= local13 (SpecActor new:))
					view: 1931
					y: (+ 165 (CelHigh 1931 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(9
				(local13 setMotion: MoveTo 160 0 local13)
				((= local14 (SpecActor new:))
					view: 1930
					y: (+ 165 (CelHigh 1930 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(10
				(local14 setMotion: MoveTo 160 0 local14)
				((= local15 (SpecActor new:))
					view: 1933
					y: (+ 165 (CelHigh 1933 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(11
				(local15 setMotion: MoveTo 160 0 local15)
				((= local16 (SpecActor new:))
					view: 1932
					y: (+ 165 (CelHigh 1932 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(12
				(local16 setMotion: MoveTo 160 0 local16)
				((= local17 (SpecActor new:))
					view: 1935
					y: (+ 165 (CelHigh 1935 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(13
				(local17 setMotion: MoveTo 160 0 local17)
				((= local18 (SpecActor new:))
					view: 1933
					setLoop: 1 1
					y: (+ 165 (CelHigh 1933 1 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(14
				(local18 setMotion: MoveTo 160 0 local18)
				((= local19 (SpecActor new:))
					view: 1934
					y: (+ 165 (CelHigh 1934 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(15
				(local19 setMotion: MoveTo 160 0 local19)
				((= local20 (SpecActor new:))
					view: 1936
					setLoop: 0 1
					y: (+ 165 (CelHigh 1936 0 0))
					init:
					setMotion: MoveTo 160 162 self
				)
			)
			(16
				(local20 setMotion: MoveTo 160 0 local20)
				((= local21 (SpecActor new:))
					view: 1936
					setLoop: 1 1
					y: (+ 175 (CelHigh 1936 1 0))
					init:
					setMotion: MoveTo 160 162 self
				)
			)
			(17
				(local21 setMotion: MoveTo 160 0 local21)
				((= local22 (SpecActor new:))
					view: 1936
					setLoop: 2 1
					y: (+ 165 (CelHigh 1936 2 0))
					init:
					setMotion: MoveTo 160 162 self
				)
			)
			(18
				(local22 setMotion: MoveTo 160 0 local22)
				((= local23 (SpecActor new:))
					view: 1936
					setLoop: 3 1
					y: (+ 165 (CelHigh 1936 3 0))
					init:
					setMotion: MoveTo 160 162 self
				)
			)
			(19
				(local23 setMotion: MoveTo 160 0 local23)
				((= local24 (SpecActor new:))
					view: 1936
					setLoop: 4 1
					y: (+ 135 (CelHigh 1936 4 0))
					init:
					setMotion: MoveTo 160 45 self
				)
			)
			(20
				(local24 setMotion: MoveTo 160 0 local24)
				((= local25 (SpecActor new:))
					view: 1937
					setLoop: 0 1
					y: (+ 175 (CelHigh 1937 0 0))
					init:
					setMotion: MoveTo 160 150 self
				)
			)
			(21
				(local25 setMotion: MoveTo 160 -90 local25)
				((= local26 (SpecActor new:))
					view: 1937
					setLoop: 1 1
					y: (+ 133 (CelHigh 1937 1 0))
					init:
					setMotion: MoveTo 160 150 self
				)
			)
			(22
				(local26 setMotion: MoveTo 160 -90 local26)
				((= local27 (SpecActor new:))
					view: 1937
					setLoop: 2 1
					y: (+ 168 (CelHigh 1937 2 0))
					init:
					setMotion: MoveTo 160 150 self
				)
			)
			(23
				(local27 setMotion: MoveTo 160 -90 local27)
				((= local28 (SpecActor new:))
					view: 1937
					setLoop: 3 1
					y: (+ 139 (CelHigh 1937 3 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(24
				(local28 setMotion: MoveTo 160 -90 local28)
				((= local29 (SpecActor new:))
					view: 1937
					setLoop: 4 1
					y: (+ 130 (CelHigh 1937 4 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(25
				(local29 setMotion: MoveTo 160 -90 local29)
				((= local30 (SpecActor new:))
					view: 1937
					setLoop: 5 1
					y: (+ 144 (CelHigh 1937 5 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(26
				(local30 setMotion: MoveTo 160 -90 local30)
				((= local31 (SpecActor new:))
					view: 1937
					setLoop: 6 1
					y: (+ 151 (CelHigh 1937 6 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(27
				(local31 setMotion: MoveTo 160 -90 local31)
				((= local32 (SpecActor new:))
					view: 1937
					setLoop: 7 1
					y: (+ 159 (CelHigh 1937 7 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(28
				(local32 setMotion: MoveTo 160 -90 local32)
				((= local33 (SpecActor new:))
					view: 1939
					setLoop: 3 1
					y: (+ 217 (CelHigh 1939 0 0))
					init:
					setMotion: MoveTo 160 155 self
				)
			)
			(29
				(local33 setMotion: MoveTo 160 0 local33)
				((= local34 (SpecActor new:))
					view: 1939
					setLoop: 2 1
					y: (+ 215 (CelHigh 1939 1 0))
					init:
					setMotion: MoveTo 160 155 self
				)
			)
			(30
				(local34 setMotion: MoveTo 160 0 local34)
				((= local35 (SpecActor new:))
					view: 1939
					setLoop: 1 1
					y: (+ 215 (CelHigh 1939 2 0))
					init:
					setMotion: MoveTo 160 155 self
				)
			)
			(31
				(local35 setMotion: MoveTo 160 0 local35)
				((= local36 (SpecActor new:))
					view: 1939
					setLoop: 0 1
					y: (+ 215 (CelHigh 1939 3 0))
					init:
					setMotion: MoveTo 160 155 self
				)
			)
			(32
				(local36 setMotion: MoveTo 160 -120 local36)
				(= local0 1)
				(= ticks 580)
			)
			(33
				(gGlobalSound0 fade: 0 25 10 1)
				(gThePlane drawPic: -1 10)
				(= seconds 3)
			)
			(34
				(gGame setScript: restartScr)
			)
		)
	)
)

(instance hiResMacCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: displayHiSingles self)
			)
			(1
				((= local1 (SpecActor new:)) view: 1925 posn: 160 97 init:)
				(= cycles 2)
			)
			(2
				(= ticks 180)
			)
			(3
				(local1 setMotion: MoveTo 160 0 local1)
				((= local2 (SpecActor new:))
					view: 1926
					y: (+ 165 (CelHigh 1926 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(4
				(local2 setMotion: MoveTo 160 0 local2)
				((= local3 (SpecActor new:))
					view: 1927
					y: (+ 165 (CelHigh 1927 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(5
				(local3 setMotion: MoveTo 160 0 local3)
				((= local5 (SpecActor new:))
					view: 1927
					loop: 2
					cel: 0
					y: (+ 165 (CelHigh 1927 2 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(6
				(local5 setMotion: MoveTo 160 0 local5)
				((= local11 (SpecActor new:))
					view: 1928
					y: (+ 165 (CelHigh 1928 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(7
				(local11 setMotion: MoveTo 160 0 local11)
				((= local12 (SpecActor new:))
					view: 1929
					loop: 0
					cel: 0
					y: (+ 165 (CelHigh 1929 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(8
				(local12 setMotion: MoveTo 160 0 local12)
				((= local13 (SpecActor new:))
					view: 1931
					y: (+ 165 (CelHigh 1931 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(9
				(local13 setMotion: MoveTo 160 0 local13)
				((= local14 (SpecActor new:))
					view: 1930
					y: (+ 165 (CelHigh 1930 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(10
				(local14 setMotion: MoveTo 160 0 local14)
				((= local15 (SpecActor new:))
					view: 1933
					y: (+ 165 (CelHigh 1933 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(11
				(local15 setMotion: MoveTo 160 0 local15)
				((= local16 (SpecActor new:))
					view: 1932
					y: (+ 165 (CelHigh 1932 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(12
				(local16 setMotion: MoveTo 160 0 local16)
				((= local17 (SpecActor new:))
					view: 1935
					y: (+ 165 (CelHigh 1935 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(13
				(local17 setMotion: MoveTo 160 0 local17)
				((= local18 (SpecActor new:))
					view: 1933
					setLoop: 1 1
					y: (+ 165 (CelHigh 1933 1 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(14
				(local18 setMotion: MoveTo 160 0 local18)
				((= local19 (SpecActor new:))
					view: 1934
					y: (+ 165 (CelHigh 1934 0 0))
					init:
					setMotion: MoveTo 160 130 self
				)
			)
			(15
				(local19 setMotion: MoveTo 160 0 local19)
				((= local20 (SpecActor new:))
					view: 1936
					setLoop: 0 1
					y: (+ 165 (CelHigh 1936 0 0))
					init:
					setMotion: MoveTo 160 162 self
				)
			)
			(16
				(local20 setMotion: MoveTo 160 0 local20)
				((= local21 (SpecActor new:))
					view: 1936
					setLoop: 1 1
					y: (+ 175 (CelHigh 1936 1 0))
					init:
					setMotion: MoveTo 160 162 self
				)
			)
			(17
				(local21 setMotion: MoveTo 160 0 local21)
				((= local22 (SpecActor new:))
					view: 1936
					setLoop: 2 1
					y: (+ 165 (CelHigh 1936 2 0))
					init:
					setMotion: MoveTo 160 162 self
				)
			)
			(18
				(local22 setMotion: MoveTo 160 0 local22)
				((= local23 (SpecActor new:))
					view: 1936
					setLoop: 3 1
					y: (+ 165 (CelHigh 1936 3 0))
					init:
					setMotion: MoveTo 160 162 self
				)
			)
			(19
				(local23 setMotion: MoveTo 160 0 local23)
				((= local24 (SpecActor new:))
					view: 1936
					setLoop: 4 1
					y: (+ 135 (CelHigh 1936 4 0))
					init:
					setMotion: MoveTo 160 45 self
				)
			)
			(20
				(local24 setMotion: MoveTo 160 0 local24)
				((= local25 (SpecActor new:))
					view: 1937
					setLoop: 0 1
					y: (+ 175 (CelHigh 1937 0 0))
					init:
					setMotion: MoveTo 160 150 self
				)
			)
			(21
				(local25 setMotion: MoveTo 160 -90 local25)
				((= local26 (SpecActor new:))
					view: 1937
					setLoop: 1 1
					y: (+ 133 (CelHigh 1937 1 0))
					init:
					setMotion: MoveTo 160 150 self
				)
			)
			(22
				(local26 setMotion: MoveTo 160 -90 local26)
				((= local27 (SpecActor new:))
					view: 1937
					setLoop: 2 1
					y: (+ 168 (CelHigh 1937 2 0))
					init:
					setMotion: MoveTo 160 150 self
				)
			)
			(23
				(local27 setMotion: MoveTo 160 -90 local27)
				((= local28 (SpecActor new:))
					view: 1937
					setLoop: 3 1
					y: (+ 139 (CelHigh 1937 3 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(24
				(local28 setMotion: MoveTo 160 -90 local28)
				((= local29 (SpecActor new:))
					view: 1937
					setLoop: 4 1
					y: (+ 130 (CelHigh 1937 4 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(25
				(local29 setMotion: MoveTo 160 -90 local29)
				((= local30 (SpecActor new:))
					view: 1937
					setLoop: 5 1
					y: (+ 144 (CelHigh 1937 5 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(26
				(local30 setMotion: MoveTo 160 -90 local30)
				((= local31 (SpecActor new:))
					view: 1937
					setLoop: 6 1
					y: (+ 151 (CelHigh 1937 6 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(27
				(local31 setMotion: MoveTo 160 -90 local31)
				((= local32 (SpecActor new:))
					view: 1937
					setLoop: 7 1
					y: (+ 159 (CelHigh 1937 7 0))
					init:
					setMotion: MoveTo 160 140 self
				)
			)
			(28
				(local32 setMotion: MoveTo 160 -90 local32)
				((= local33 (SpecActor new:))
					view: 1939
					setLoop: 3 1
					y: (+ 217 (CelHigh 1939 0 0))
					init:
					setMotion: MoveTo 160 155 self
				)
			)
			(29
				(local33 setMotion: MoveTo 160 0 local33)
				((= local34 (SpecActor new:))
					view: 1939
					setLoop: 2 1
					y: (+ 215 (CelHigh 1939 1 0))
					init:
					setMotion: MoveTo 160 155 self
				)
			)
			(30
				(local34 setMotion: MoveTo 160 0 local34)
				((= local35 (SpecActor new:))
					view: 1939
					setLoop: 1 1
					y: (+ 215 (CelHigh 1939 2 0))
					init:
					setMotion: MoveTo 160 155 self
				)
			)
			(31
				(local35 setMotion: MoveTo 160 0 local35)
				((= local36 (SpecActor new:))
					view: 1939
					setLoop: 0 1
					y: (+ 215 (CelHigh 1939 3 0))
					init:
					setMotion: MoveTo 160 155 self
				)
			)
			(32
				(local36 setMotion: MoveTo 160 -120 local36)
				(= local0 1)
				(= ticks 580)
			)
			(33
				(gGlobalSound0 fade: 0 25 10 1)
				(gThePlane drawPic: -1 10)
				(= seconds 3)
			)
			(34
				(gGame setScript: restartScr)
			)
		)
	)
)

(instance displayHiSingles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(= cycles 2)
			)
			(1
				(credView
					posn: 160 97
					view: (+ 1920 register)
					loop: (if next 1 else 0)
					cel: 0
					init:
				)
				(cond
					(next
						(= next 0)
					)
					((== (credView view:) 1921)
						(= next 1)
					)
				)
				(= cycles 2)
			)
			(2
				(= ticks 180)
			)
			(3
				(credView dispose:)
				(= cycles 1)
			)
			(4
				(= ticks 60)
			)
			(5
				(if (not next)
					(++ register)
				)
				(if (< register 5)
					(self changeState: 1)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance credView of Actor
	(properties
		view 1940
	)
)

(class SpecActor of Actor
	(properties
		x 160
		priority 5
		fixPriority 1
		view 1940
		yStep 1
		moveSpeed 0
	)

	(method (init)
		(if (IsHiRes)
			(= yStep 2)
		)
		(super init: &rest)
		(self ignoreActors: 1 ignoreHorizon: 1)
	)

	(method (cue)
		(self dispose:)
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
	)
)

(instance credPlane of Plane
	(properties
		picture 0
		priority 30
	)

	(method (init)
		(= picture 0)
		(self setRect: 0 165 320 199)
		(super init: &rest)
		(FrameOut)
	)
)

(instance restartScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds eachElementDo: #stop)
				(PalVary 3) ; PalVaryKill
				(= cycles 5)
			)
			(1
				(= gQuit 1)
			)
		)
	)
)

